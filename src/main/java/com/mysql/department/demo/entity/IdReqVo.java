package com.mysql.department.demo.entity;

import java.io.Serializable;

public class IdReqVo implements Serializable {
    private static final long serialVersionUID = 831118961080345672L;
    private  String empNo;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
}
