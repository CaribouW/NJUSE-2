package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 影院角色管理
 * 主要进行影院中, 角色为 'admin' 的账号的增删改查
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

    @PostMapping("/new")
    public JSON addAdmin(@RequestBody JSONObject req) {
        return roleService.addAdmin(req.getString("account"),
                req.getString("password"));
    }

    @PutMapping("/")
    public JSON updateAdmin(@RequestBody JSONObject req) {
        return roleService.updateAdmin(req);
    }

    @DeleteMapping("/")
    public JSON deleteAdmin(@RequestBody JSONObject req) {
        return roleService.deleteAdmin(req.getString("userId"));
    }
}
