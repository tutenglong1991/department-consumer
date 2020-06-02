package com.mysql.department.demo.entity;

import java.sql.Date;
import java.io.Serializable;

/**
 * (DeptManager)实体类
 *
 * @author makejava
 * @since 2020-06-02 16:24:31
 */
public class DeptManager implements Serializable {
    private static final long serialVersionUID = 831118961080300592L;
    
    private Integer empNo;
    
    private String deptNo;
    
    private Date fromDate;
    
    private Date toDate;


    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

}