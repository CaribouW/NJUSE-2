package com.example.main.controller;

import com.example.main.repository.UserInfoRepository;
import com.example.main.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private UserInfoRepository userInfoRepository;

}
