package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.response.BaseResponse;
import com.example.main.core.security.token.TokenManager;
import com.example.main.model.MovieInfo;
import com.example.main.model.User;
import com.example.main.repository.FavorListRepository;
import com.example.main.repository.MovieInfoRepository;
import com.example.main.repository.UserRepository;
import com.example.main.service.HallService;
import com.example.main.utils.IDUtils;
import com.example.main.utils.OssUtils;
import com.example.main.utils.SignUpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private OssUtils ossUtils;
    @Autowired
    private HallService hallService;

    @GetMapping("/")
    public BaseResponse he() {
        hallService
        return BaseResponse.SUCCESS();
    }



}
