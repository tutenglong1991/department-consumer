package com.mysql.department.demo.controller;

import com.mysql.department.demo.entity.DeptManager;
import com.mysql.department.demo.service.api.DeptManagerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * (DeptManager)表控制层
 *
 * @author makejava
 * @since 2020-06-02 16:24:34
 */
@RestController
@RequestMapping("deptManager")
public class DeptManagerController {
    /**
     * 服务对象
     * 此处若不加参数会报错：Consider defining a bean of type
     * 'com.mysql.department.demo.service.api.DeptManagerService' in your configuration
     * 当不能确定 Spring 容器中一定拥有某个类的 Bean 时，可以在需要自动注入该类 Bean 的地方可以使用
     * @Autowired(required = false)，这等于告诉 Spring：在找不到匹配 Bean 时也不报错
     * 当然，一般情况下，使用 @Autowired 的地方都是需要注入 Bean 的，使用了自动注入而又允许不注入的情况一般仅会在开发期或测试期碰到（
     * 如为了快速启动 Spring 容器，仅引入一些模块的 Spring 配置文件），所以 @Autowired(required = false) 会很少用到
     *
     * 故若此处报错找不到xxxx.xxx.xx.DeptManagerService,其实是实现DeptManagerService的接口类没有加@Component
     *
     */
    @Autowired
    private DeptManagerService deptManagerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public List<DeptManager> selectOne(String id) {
        return this.deptManagerService.queryByDeptId(id);
    }

}