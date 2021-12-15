package com.mysql.department.demo.common;

public enum ResultCodeEnum {
    SUCCESS(Integer.valueOf(0), "success", "成功"),
    FAILED(69999, "department system error", "系统内部异常，请联系管理员"),
    OTHER_ERROR(68888, "other system error", "其他系统内部异常，请联系管理员"),
    DEPT_NUM_IS_NULL(67777, "deptNo can not be null", "部门id不能为空"),
    REQ_PARAMS_ERROR(Integer.valueOf(60000), "req params error", "请求参数错误"),
    DEPT_NUM_IS_TEST_JACOCO(11111, "deptNo can is test_jacoco", "部门id为测试jacoco增量覆盖值");

    private Integer code;
    private String msg;
    private String cnMsg;

    private ResultCodeEnum(Integer code, String msg, String cnMsg) {
        this.code = code;
        this.msg = msg;
        this.cnMsg = cnMsg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCnMsg() {
        return this.cnMsg;
    }
}