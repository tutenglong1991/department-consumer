package com.mysql.department.demo.dao;

import com.mysql.department.demo.entity.Departments;
import com.mysql.department.demo.entity.DeptAndEmployees;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Departments)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 13:27:58
 */
public interface DepartmentsDao {


    /**
     * 通过部门id查询部门下所有主管的个人详细信息
     *
     * @param id 主键
     * @return 多条数据
     */
    DeptAndEmployees getDeptManagerInfo(String deptNo);

    /**
     * 通过ID查询单条数据
     *
     * @param deptNo 主键
     * @return 实例对象
     */
    Departments queryById(String deptNo);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Departments> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param departments 实例对象
     * @return 对象列表
     */
    List<Departments> queryAll(Departments departments);

    /**
     * 新增数据
     *
     * @param departments 实例对象
     * @return 影响行数
     */
    int insert(Departments departments);

    /**
     * 修改数据
     *
     * @param departments 实例对象
     * @return 影响行数
     */
    int update(Departments departments);

    /**
     * 通过主键删除数据
     *
     * @param deptNo 主键
     * @return 影响行数
     */
    int deleteById(String deptNo);

}