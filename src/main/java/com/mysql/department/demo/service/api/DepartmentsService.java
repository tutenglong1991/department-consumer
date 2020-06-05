package com.mysql.department.demo.service.api;

import com.mysql.department.demo.entity.CrossPlatformResponse;
import com.mysql.department.demo.entity.Departments;

import java.util.List;

/**
 * (Departments)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 13:28:01
 */
public interface DepartmentsService {

    /**
     * 通过部门id查询部门下所有主管的个人详细信息
     *
     * @param id 主键
     * @return 多条数据
     */
    CrossPlatformResponse getDeptManagerInfo(String deptNo);


    /**
     * 通过ID查询单条数据
     *
     * @param deptNo 主键
     * @return 实例对象
     */
    Departments queryById(String deptNo);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Departments> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param departments 实例对象
     * @return 实例对象
     */
    Departments insert(Departments departments);

    /**
     * 修改数据
     *
     * @param departments 实例对象
     * @return 实例对象
     */
    Departments update(Departments departments);

    /**
     * 通过主键删除数据
     *
     * @param deptNo 主键
     * @return 是否成功
     */
    boolean deleteById(String deptNo);

}