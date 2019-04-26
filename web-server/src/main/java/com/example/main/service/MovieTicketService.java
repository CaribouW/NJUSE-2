package com.example.main.service;

import com.example.main.model.MemberList;
import com.example.main.model.MovieInfo;
import com.example.main.model.MovieTicket;
import com.example.main.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 专门服务于购票/退改票 用例;
 * 包含了 选座;生成订单;购买
 * 退票;查看历史订单
 */
@Service
public class MovieTicketService {
    @Autowired
    private MemberListRepository memberListRepository;
    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    private MovieTicketRepository movieTicketRepository;
    @Autowired
    private PreferentialRepository preferentialRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
}
