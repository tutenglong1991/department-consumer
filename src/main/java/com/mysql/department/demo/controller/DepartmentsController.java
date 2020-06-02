package com.mysql.department.demo.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.department.demo.entity.Departments;
import com.mysql.department.demo.entity.DeptAndEmployees;
import com.mysql.department.demo.entity.DeptManager;
import com.mysql.department.demo.service.api.DepartmentsService;
import com.mysql.department.demo.service.api.DeptManagerService;
import com.mysql.employee.demo.entity.Employees;
import com.mysql.employee.demo.service.api.EmployeesService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * (Departments)表控制层
 *
 * @author makejava
 * @since 2020-06-01 13:28:05
 */
@RestController
@RequestMapping("departments")
public class DepartmentsController {
    /**
     * 服务对象
     * Reference表示注入，但是是表示将另外一个远程服务对象当做spring容易中的对象一样注入，这个是dubbo的注解
     * Resource就是spring的资源注入
     */
    //这里要使用Reference注解，因为该服务的实现类在其他分布式部署的服务中，需将其bean注入到当前容器内
//    @Reference(url="dubbo://192.168.0.101:20880/com.mysql.employee.demo.service.api.EmployeesService")
    @Reference(url="dubbo://172.21.0.7:20880/com.mysql.employee.demo.service.api.EmployeesService")
    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private DepartmentsService departmentsService;

    @Autowired
    private DeptManagerService deptManagerService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getDeptManagerListByDeptId")
    public DeptAndEmployees  getDeptManagerListByDeptId(String id) {
        //查询部门表，获取部门名称和编号
        Departments Departments = departmentsService.queryById(id);
        String deptNo = Departments.getDeptNo();
        String deptName = Departments.getDeptName();

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
        System.out.println(JSON.toJSONString(deptAndEmployees));
        return deptAndEmployees;
    }

}