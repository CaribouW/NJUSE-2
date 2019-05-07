package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.model.FavorList;
import com.example.main.model.MovieInfo;
import com.example.main.model.User;
import com.example.main.repository.FavorListRepository;
import com.example.main.repository.MovieInfoRepository;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserRepository;
import com.example.main.repository.mapper.UserMapper;
import com.example.main.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private FavorListRepository favorListRepository;

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    private class Response {
        public JSON data;
        public String message;

        public Response(JSON data, String message) {
            this.data = data;
            this.message = message;
        }
    }

    @GetMapping("/")
    public Response he() {
        JSONObject jsonObject = new JSONObject();
        Response response = new Response(jsonObject, "ready");
        List<MovieInfo> list = movieInfoRepository.findMovieByUserId("1");
        return response;
    }


}
