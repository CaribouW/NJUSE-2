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
import com.example.main.utils.SignUpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private FavorListRepository favorListRepository;

    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    TokenManager tokenManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SignUpHelper signUpHelper;
    @Autowired
    private IDUtils idUtils;

    private class Response {
        public JSONObject data;
        public String message;

        public Response(JSONObject data, String message) {
            this.data = data;
            this.message = message;
        }
    }

    @GetMapping("/")
    public BaseResponse he() {
        JSONObject jsonObject = new JSONObject();
        User user = new User();
        user.setUserId(idUtils.getUUID32());
        user.setPassword(signUpHelper.encryptPassword("123"));
        userRepository.saveAndFlush(user);
        try {
            user.setPassword("123");
            if (!tokenManager.isLogin())
                tokenManager.loginPsw(user, true);
            else {
                return BaseResponse.FAIL(404);
            }
            return BaseResponse.SUCCESS(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.FAIL(404);
        }


    }

    @GetMapping("/logout")
    public BaseResponse logout() {
        JSONObject jsonObject = new JSONObject();
        Response response = new Response(jsonObject, "success");
        if (tokenManager.isLogin())
            tokenManager.logout();
        else {
            response.message = "fail";
            return BaseResponse.FAIL(404);
        }
        return BaseResponse.SUCCESS(jsonObject);
    }
}
