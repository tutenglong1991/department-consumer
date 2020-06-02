package com.mysql.department.demo.dao;

import com.mysql.department.demo.entity.DeptAndEmployees;
import com.mysql.department.demo.entity.DeptManager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DeptManager)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-02 16:24:33
 */
public interface DeptManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param empNo 主键
     * @return 实例对象
     */
    DeptManager queryById(Integer empNo);

    /**
     * 通过部门ID查询多条数据
     *
     * @param deptNo 主键
     * @return 实例对象
     */
    List<DeptManager> queryByDeptId(@Param("deptNo") String deptNo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DeptManager> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param deptManager 实例对象
     * @return 对象列表
     */
    List<DeptManager> queryAll(DeptManager deptManager);

    /**
     * 新增数据
     *
     * @param deptManager 实例对象
     * @return 影响行数
     */
    int insert(DeptManager deptManager);

    /**
     * 修改数据
     *
     * @param deptManager 实例对象
     * @return 影响行数
     */
    int update(DeptManager deptManager);

    /**
     * 通过主键删除数据
     *
     * @param empNo 主键
     * @return 影响行数
     */
    int deleteById(Integer empNo);

}