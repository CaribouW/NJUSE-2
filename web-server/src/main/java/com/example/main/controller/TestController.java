package com.example.main.controller;

import com.example.main.service.HallService;
import com.example.main.utils.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Controller
public class TestController {
    @Autowired
    private OssUtils ossUtils;
    @Autowired
    private HallService hallService;

    @GetMapping("/")
    @ResponseBody
    public String he() {
        return "index";
    }


}
