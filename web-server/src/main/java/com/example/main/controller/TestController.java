package com.example.main.controller;

import com.example.main.core.enums.RoleType;
import com.example.main.model.UserInfo;
import com.example.main.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @PostMapping("/test")
    public ResponseEntity<Object> he(@RequestBody Date date) {
        System.out.println(date);
        return null;
    }


}
