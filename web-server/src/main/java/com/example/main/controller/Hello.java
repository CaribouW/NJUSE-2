package com.example.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.main.model.Role;
import com.example.main.model.User;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserRepository;
import com.example.main.utils.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Controller
public class Hello {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @RequestMapping("/demo")
    public String hell(){
        return "index";
    }

}
