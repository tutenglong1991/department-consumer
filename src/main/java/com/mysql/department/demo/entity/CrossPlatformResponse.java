package com.mysql.department.demo.entity;

import java.io.Serializable;

/**
 * 与PHP交互的响应对象
 */
public class CrossPlatformResponse implements Serializable {

    private static final long serialVersionUID = 3468809980704226548L;

    private Integer code = 0;

    private String message = "success";

    private Object data;

    public CrossPlatformResponse() {
    }

    public CrossPlatformResponse(Integer code) {
        this.code = code;
    }

    public CrossPlatformResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CrossPlatformResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CrossPlatformResponse(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}