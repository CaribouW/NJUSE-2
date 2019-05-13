package com.example.main.service.impl;

import com.example.main.repository.MovieHallRepository;
import com.example.main.repository.MovieTicketRepository;
import com.example.main.repository.TimeSlotRepository;
import com.example.main.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 影厅信息更改
 * 包括了管理员管理影厅信息,排片管理;购票时座位修改;排片
 */
@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private MovieHallRepository movieHallRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private MovieTicketRepository movieTicketRepository;

    @Override
    public void run() {

    }
}
