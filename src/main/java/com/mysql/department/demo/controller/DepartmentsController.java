package com.mysql.department.demo.controller;

import com.mysql.department.demo.entity.CrossPlatformResponse;
import com.mysql.department.demo.entity.Departments;
import com.mysql.department.demo.entity.IdReqVo;
import com.mysql.department.demo.service.api.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * (Departments)表控制层
 *
 * @author makejava
 * @since 2020-06-01 13:28:05
 */
@RestController
@RequestMapping("departments")
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "getDeptManagerListByDeptId", method = RequestMethod.GET)
    public CrossPlatformResponse getDeptManagerListByDeptId(String id) {
        return this.departmentsService.getDeptManagerInfo(id);
    }

    @RequestMapping(value = "getDeptManagerListByEmpNo", method = RequestMethod.POST)
    public Departments getDeptManagerListByEmpNo(@RequestBody IdReqVo idReqVo) {
        return this.departmentsService.queryById(idReqVo.getEmpNo());
    }
}