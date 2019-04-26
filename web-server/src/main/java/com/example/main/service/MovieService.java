package com.example.main.service;

import com.example.main.repository.FavorListRepository;
import com.example.main.repository.MovieInfoRepository;
import com.example.main.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 主要职能:
 * 用户端——详细电影信息查看;想看电影操作;用户查看排片信息
 * 管理员端——电影上架管理;
 */
@Service
public class MovieService {
    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    private FavorListRepository favorListRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
}
