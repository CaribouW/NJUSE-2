package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.example.main.model.User;
import com.example.main.service.HallService;
import com.example.main.utils.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class TestController {
    @Autowired
    private OssUtils ossUtils;
    @Autowired
    private HallService hallService;

    @GetMapping("/")
    public JSON he() {
        Object object = new User("aa", "ss");
        return null;
    }


}
