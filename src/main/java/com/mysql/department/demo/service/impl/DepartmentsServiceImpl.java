package com.mysql.department.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.mysql.department.demo.entity.CrossPlatformResponse;
import com.mysql.department.demo.entity.Departments;
import com.mysql.department.demo.dao.DepartmentsDao;
import com.mysql.department.demo.entity.DeptAndEmployees;
import com.mysql.department.demo.entity.DeptManager;
import com.mysql.department.demo.service.api.DepartmentsService;
import com.mysql.department.demo.service.api.DeptManagerService;
import com.mysql.employee.demo.entity.Employees;
import com.mysql.employee.demo.service.api.EmployeesService;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.mysql.department.demo.common.ResultCodeEnum.*;

/**
 * (Departments)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 13:28:03
 */
@Service
@Component
public class DepartmentsServiceImpl implements DepartmentsService {

    private final static Logger logger = LoggerFactory.getLogger(DepartmentsServiceImpl.class);

    @Resource
    private DepartmentsDao departmentsDao;
    /**
     * 服务对象
     * Reference表示注入，但是是表示将另外一个远程服务对象当做spring容易中的对象一样注入，这个是dubbo的注解
     * Resource就是spring的资源注入
     */
    //这里要使用Reference注解，因为该服务的实现类在其他分布式部署的服务中，需将其bean注入到当前容器内
//    @Reference(url="dubbo://192.168.0.103:20880/com.mysql.employee.demo.service.api.EmployeesService")
    @Reference(url="dubbo://172.21.0.7:20880/com.mysql.employee.demo.service.api.EmployeesService")
    @Autowired
    private EmployeesService employeesService;

    //此处自动注入不需要Reference注解，但是实现类得有Component注解
    @Autowired
    private DeptManagerService deptManagerService;

//    @Autowired
//    private DepartmentsService departmentsService;


    /**
     * 通过部门id查询部门下所有主管的个人详细信息
     *
     * @param id 主键
     * @return 多条数据
     */
    public CrossPlatformResponse getDeptManagerInfo(String id){
        if (id == null || StringUtils.isBlank(id)){
            return new CrossPlatformResponse(DEPT_NUM_IS_NULL.getCode(), DEPT_NUM_IS_NULL.getMsg());
        }
        logger.info("查询部门管理员详细信息的请求参数为：" + id);
        //查询部门表，获取部门名称和编号
        Departments departments = this.queryById(id);
        if (departments == null){
            return new CrossPlatformResponse(REQ_PARAMS_ERROR.getCode(), "部门id不存在");
        }
        String deptNo = departments.getDeptNo();
        String deptName = departments.getDeptName();

        //实例化部门管理员个人信息详情类并赋值
        DeptAndEmployees deptAndEmployees = new DeptAndEmployees();
        //查询dept_manager表格，获取该部门下的所有管理员
        List<DeptManager> deptManagers = deptManagerService.queryByDeptId(id);
        deptAndEmployees.setDeptNo(deptNo);
        deptAndEmployees.setDeptName(deptName);
        //根据dept_manager表格中的empNo字段，逐个查询员工信息中的详细信息，并赋值给deptAndEmployees的deptManagerInfoList属性
        List<Employees> employeeList = new ArrayList<>();
        for(DeptManager deptManager: deptManagers) {
            int empNo = deptManager.getEmpNo();
            Employees employee = employeesService.queryById(empNo);
            employeeList.add(employee);
        }
        deptAndEmployees.setDeptManagerInfoList(employeeList);
        logger.info("返回deptAndEmployees对象json格式参数为:{}", JSON.toJSONString(deptAndEmployees));
        return new CrossPlatformResponse(200, "success", deptAndEmployees);
    }



    /**
     * 通过ID查询单条数据
     *
     * @param deptNo 主键
     * @return 实例对象
     */
    @Override
    public Departments queryById(String deptNo) {
        return this.departmentsDao.queryById(deptNo);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Departments> queryAllByLimit(int offset, int limit) {
        return this.departmentsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param departments 实例对象
     * @return 实例对象
     */
    @Override
    public Departments insert(Departments departments) {
        this.departmentsDao.insert(departments);
        return departments;
    }

    /**
     * 修改数据
     *
     * @param departments 实例对象
     * @return 实例对象
     */
    @Override
    public Departments update(Departments departments) {
        this.departmentsDao.update(departments);
        return this.queryById(departments.getDeptNo());
    }

    /**
     * 通过主键删除数据
     *
     * @param deptNo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String deptNo) {
        return this.departmentsDao.deleteById(deptNo) > 0;
    }
}