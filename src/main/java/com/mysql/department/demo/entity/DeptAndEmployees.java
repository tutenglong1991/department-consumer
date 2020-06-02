package com.mysql.department.demo.entity;

import com.mysql.employee.demo.entity.Employees;

import java.io.Serializable;
import java.util.List;

public class DeptAndEmployees implements Serializable {

    private static final long serialVersionUID = 509440638572106569L;

    private String deptNo;

    private String deptName;

    private List<Employees> deptManagerInfoList;


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


    public List<Employees> getDeptManagerInfoList() {
        return deptManagerInfoList;
    }

    public void setDeptManagerInfoList(List<Employees> deptManagerInfoList) {
        this.deptManagerInfoList = deptManagerInfoList;
    }
}
