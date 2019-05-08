package com.example.main.core.response;

import com.alibaba.fastjson.JSON;

public class BaseResponse {
    public int status;
    public JSON data;
    public String message;

    private BaseResponse() {
        this.status = 0;
        this.data = null;
        this.message = null;
    }

    private BaseResponse(int status, JSON data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static BaseResponse SUCCESS() {
        return new BaseResponse(200, null, "success");
    }

    public static BaseResponse SUCCESS(JSON data) {
        return new BaseResponse(200, data, "success");
    }

    public static BaseResponse FAIL(int status) {
        return new BaseResponse(status, null, "fail");
    }
}
