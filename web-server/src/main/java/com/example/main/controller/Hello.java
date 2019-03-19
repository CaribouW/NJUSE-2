package com.example.main.controller;

import com.example.main.core.security.session.CustomShiroSessionDAO;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserRepository;
import com.example.main.utils.SessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class Hello {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SessionUtils sessionUtils;

    @RequestMapping("/demo")
    public String hell() {
        String s =
                (String) sessionUtils.getValue("as");
        return "index";
    }

    @RequestMapping("/dem")
    public String h() {
        EnterpriseCacheSessionDAO dao = new EnterpriseCacheSessionDAO();
        sessionUtils.setAttribute("as", "as");

        return "";
    }

}
