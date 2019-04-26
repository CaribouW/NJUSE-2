package com.example.main.service;

import com.example.main.repository.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 专用于电影数据统计
 */
@Service
public class MovieCountService {
    @Autowired
    private MovieInfoRepository movieInfoRepository;
}
