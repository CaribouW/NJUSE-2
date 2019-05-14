package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.example.main.service.HallService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HallController {
    @Autowired
    private HallService hallService;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private IDUtils idUtils;

    @GetMapping("/hall/strategy/list")
    public JSON getHallList(){
        return hallService.getHallList();
    }
}
