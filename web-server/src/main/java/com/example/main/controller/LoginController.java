package com.example.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.main.core.response.BaseResponse;
import com.example.main.model.User;
import com.example.main.repository.UserInfoRepository;
import com.example.main.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping(value = "/user/login")
    public BaseResponse userLogin(@RequestBody JSONObject req) {
        return loginService.login(req.getString("account"), req.getString("password"));
    }

    @PostMapping(value = "/user/register")
    public BaseResponse userRegister(@RequestBody JSONObject req) {
        return loginService.register(req.getString("account"), req.getString("password"));
    }
}
