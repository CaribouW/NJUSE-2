package com.example.main.controller;

import com.example.main.dao.UserDao;
import com.example.main.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String run() {
        return String.valueOf(userDao.selectByKey("lfm"));
    }
}
