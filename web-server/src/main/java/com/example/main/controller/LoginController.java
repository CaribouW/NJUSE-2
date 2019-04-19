package com.example.main.controller;

import com.example.main.model.User;
import com.example.main.model.UserInfo;
import com.example.main.repository.UserInfoRepository;
import com.example.main.repository.UserRepository;
import com.example.main.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping(value = "/hel")
    public void setame() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("as的");
        userInfo.setName("你好");
        userInfoRepository.save(userInfo);
    }
}
