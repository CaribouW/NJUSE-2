package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.LoginService;
import com.example.main.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/user/login")
    public JSON userLogin(@RequestBody JSONObject req) {
        return loginService.login(req.getString("account"), req.getString("password"));
    }

    @PostMapping(value = "/user/register")
    public JSON userRegister(@RequestBody JSONObject req) {
        return loginService.register(req.getString("account"), req.getString("password"));
    }

    @DeleteMapping(value = "/user/logout")
    public JSON userLogout(@RequestParam(name = "userId") String uid) {
        return loginService.logout(uid);
    }

}
