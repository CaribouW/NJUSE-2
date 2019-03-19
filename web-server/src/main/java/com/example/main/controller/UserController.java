package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/hello")
    public Mono<String> hello() {   // 返回类型为Mono<String>
        return Mono.just("Welcome to reactive world ~");     // 使用Mono.just生成响应式数据
    }

    //    @RequestMapping(value = "/sasa",method = RequestMethod.POST)
    @PostMapping("/sasa")
    public JSON dasda(@RequestBody JSONObject jsonObject) {
        String s =
                jsonObject.getString("name");
        return null;
    }

}
