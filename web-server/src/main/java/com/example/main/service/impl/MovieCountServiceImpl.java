package com.example.main.service.impl;

import com.example.main.repository.MovieHallRepository;
import com.example.main.repository.MovieInfoRepository;
import com.example.main.repository.MovieTicketRepository;
import com.example.main.repository.TimeSlotRepository;
import com.example.main.service.MovieCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 专用于电影数据统计
 */
@Service
public class MovieCountServiceImpl implements MovieCountService {
    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private MovieTicketRepository movieTicketRepository;
    @Autowired
    private MovieHallRepository movieHallRepository;
}
