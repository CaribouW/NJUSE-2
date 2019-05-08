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

    @GetMapping("/")
    public BaseResponse he() {
        String url = ossUtils.getUploadURL("F:\\Project github\\NJUSE-2\\web-server\\src\\main\\resources\\static\\info.png");
        String u = ossUtils.getDownloadURL(url);
        System.out.println(url);
        System.out.println(u);
        return BaseResponse.SUCCESS();
    }


}
