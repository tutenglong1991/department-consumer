package com.mysql.department.demo.service.impl;

import com.mysql.department.demo.entity.Departments;
import com.mysql.department.demo.dao.DepartmentsDao;
import com.mysql.department.demo.service.DepartmentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Departments)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 13:28:03
 */
@Service("departmentsService")
public class DepartmentsServiceImpl implements DepartmentsService {
    @Resource
    private DepartmentsDao departmentsDao;

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