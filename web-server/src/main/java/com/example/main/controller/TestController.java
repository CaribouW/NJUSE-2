package com.example.main.controller;

import com.example.main.repository.FavorListRepository;
import com.example.main.service.HallService;
import com.example.main.utils.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Controller
public class TestController {
    @Autowired
    private OssUtils ossUtils;
    @Autowired
    private HallService hallService;
    @Autowired
    private FavorListRepository favorListRepository;

    @GetMapping("/")
    @ResponseBody
    public String he() {
        HashMap<String, Object> hashMap = new HashMap<>();
        List<String> ids = new LinkedList<>();
        hashMap.put("movie_id", ids);
        ids=favorListRepository.findMovieIdsMostFavorSorted();
        return "index";
    }


}
