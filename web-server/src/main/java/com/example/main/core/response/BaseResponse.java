package com.example.main.core.response;

import com.alibaba.fastjson.JSON;

public class BaseResponse {
    public int status;
    public JSON data;
    public String message;

    public BaseResponse() {
        this.status = 0;
        this.data = null;
        this.message = null;
    }

    public BaseResponse(int status, JSON data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
