package com.example.main.controller;

import com.example.main.model.Role;
import com.example.main.model.User;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Hello {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/")
    public String run() {
        List<String> list=userRepository.findRolesByUserId("1");
        if (!list.isEmpty())
            return list.get(0);
        else
            return "";
    }
}
