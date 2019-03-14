package com.example.main.controller;

import com.example.main.model.Role;
import com.example.main.model.User;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/")
    public String run() {
        Role role=roleRepository.findByRoleId("001");
        userRepository.deleteByUserId("1");
        return String.valueOf(userRepository.findAll().size());
    }
}
