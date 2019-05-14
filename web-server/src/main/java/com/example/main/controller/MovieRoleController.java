package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 影院角色管理
 */
@RestController
@RequestMapping("/admin")
public class MovieRoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public JSON getAllAdmins() {
        return roleService.getAllAdmins();
    }

    @PostMapping("/")
    public JSON addAdmin(@RequestBody JSONObject req) {
        return roleService.addAdmin(req);
    }
}
