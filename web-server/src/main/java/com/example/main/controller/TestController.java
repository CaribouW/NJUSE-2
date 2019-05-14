package com.example.main.controller;

import com.example.main.core.enums.RoleType;
import com.example.main.model.UserInfo;
import com.example.main.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/")
    @ResponseBody
    public String he() {
        List<UserInfo> userInfos =
                userInfoRepository.findALLByRole(RoleType.AUDIENCE.getContent());
        return "index";
    }


}
