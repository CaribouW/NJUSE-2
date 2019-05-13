package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.LoginService;
import com.example.main.service.MovieService;
import com.example.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;
    @PostMapping("/favor")
    public JSON postFavor(@RequestBody JSONObject req) {
        return userService.postFavor(req.getString("userId"),
                req.getString("movieId"));
    }

    @DeleteMapping("/favor")
    public JSON deleteFavor(@RequestBody JSONObject req) {
        return userService.deleteFavor(req.getString("userId"),
                req.getString("movieId"));
    }

    @GetMapping("/favor/counter")
    public JSON getMovieFavorNum(@RequestParam(value = "movieId") String mid){
        return movieService.getMovieFavorNum(mid);
    }

    @GetMapping("/user/basicInfo")
    public JSON getBasicInfo(@RequestParam(value = "id")String uid){
        return userService.getUserInfo(uid);
    }

}
