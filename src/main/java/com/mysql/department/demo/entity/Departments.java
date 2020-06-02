package com.mysql.department.demo.entity;

import java.io.Serializable;

/**
 * (Departments)实体类
 *
 * @author makejava
 * @since 2020-06-01 13:27:57
 */
public class Departments implements Serializable {
    private static final long serialVersionUID = 509440638572106569L;
    
    private String deptNo;
    
    private String deptName;


    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}