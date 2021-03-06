package com.example.main.core.enums;

public enum ResponseType {
    SUCCESS(200, "success"), //成功
    PERMISSION_DENY(401, "permission denied"), //无权限
    RESOURCE_NOT_EXIST(404, "resource not exist"), //资源不存在
    RESOURCE_ALREADY_EXIST(405, "resource already exist"), //资源已存在
    PASSWORD_ERROR(501, "Password Error"), //密码错误
    USER_IN(504, "user has already login"), //用户已登录
    USER_OUT(505, "user not login"),        //用户未登录
    REFUND_DENY(604, "Refund denied"),      //退票失败
    CONSUME_FAIL(605,"Consume Fail"),       //支付失败
    UNKNOWN_ERROR(1000, "unknown error");
    private Integer status;

    private String message;

    ResponseType(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
