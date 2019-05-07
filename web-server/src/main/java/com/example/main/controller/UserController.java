package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private LoginServiceImpl loginService;

    //    @RequestMapping(value = "/sasa",method = RequestMethod.POST)
    @PostMapping("/sasa")
    public JSON dasda(@RequestBody JSONObject jsonObject) {
        String s =
                jsonObject.getString("name");
        return null;
    }
}
