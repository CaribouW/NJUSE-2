package com.example.main.core.enums;
/**
 * 优惠返回枚举
 * */
public enum CouponType {
    INVALID(0, "invalid"),//已失效
    UN_USED(1, "unused"), //未使用
    USED(2, "used"),      //已使用
    ;
    private int code;
    private String content;

    CouponType(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
