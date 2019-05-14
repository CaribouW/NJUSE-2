package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.example.main.model.UserInfo;
import com.example.main.service.MovieCountService;
import com.example.main.service.MovieService;
import com.example.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private MovieCountService movieCountService;

    @GetMapping("/favor/rank/top")
    public JSON getTopMovieFavor(@RequestParam(value = "quantity") int top) {
        return movieCountService.getTopMovieFavor(top);
    }

    @GetMapping("/movie/detail/basicInfo")
    public JSON getDetailInfo(@RequestParam(value = "movieId") String mid,
                              @RequestParam(value = "userId") String uid) {
        return movieService.getDetail(mid, uid);
    }

    @GetMapping("/movie/detail/photo")
    public JSON getPhoto(@RequestParam(value = "movieId") String mid) {
        return movieService.getPhoto(mid);
    }

    @GetMapping("/movie/list")
    public JSON getMovieKey(){
        return null
                ;
    }

    @GetMapping("/movie/detail/staff")
    public JSON getStaff(@RequestParam(value = "movieId")String mid){
        return movieService.getStaff(mid);
    }
}
