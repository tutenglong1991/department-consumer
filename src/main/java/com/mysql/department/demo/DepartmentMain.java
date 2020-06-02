package com.mysql.department.demo;


import com.alibaba.fastjson.JSON;
import com.mysql.employee.demo.service.api.EmployeesService;
import org.apache.dubbo.config.annotation.Reference;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mysql.department.demo","com.mysql.department.demo.service.api"}) //因为这些文件用到了注解，需要加扫描，可扫很多注解
@MapperScan("com.mysql.department.demo.dao") //扫描Mybatis，即dao文件下接口，该扫描专门用来扫Mybatis
public class DepartmentMain {
//    @Reference(url="dubbo://192.168.0.101:20880/com.mysql.employee.demo.service.api.EmployeesService")
    @Reference(url="dubbo://172.21.0.7:20880/com.mysql.employee.demo.service.api.EmployeesService")

//    private EmployeesService employeesService;

    public static void main(String[] args) {
        SpringApplication.run(DepartmentMain.class);
    }

//    @Bean
//    public ApplicationRunner runner() {
//        System.out.println(employeesService);
//        return args -> System.out.println(JSON.toJSONString(employeesService.queryById(10001)));
//    }
}
