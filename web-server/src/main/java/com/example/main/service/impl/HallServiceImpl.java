package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.DateStrPattern;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.MovieHall;
import com.example.main.model.MovieTicket;
import com.example.main.model.TimeSlot;
import com.example.main.repository.MovieHallRepository;
import com.example.main.repository.MovieTicketRepository;
import com.example.main.repository.TimeSlotRepository;
import com.example.main.service.HallService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private IDUtils idUtils;

    @Override
    public JSON getAllSlots() {
        try {
            List<TimeSlot> list = timeSlotRepository.findAll();
            //按照时间由小到大
            list.sort(Comparator.comparing(TimeSlot::getStartTime));
            JSONObject ans = new JSONObject();
            //put arr
            ans.put("slot", list);
            return Response.success(ans);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }


    @Override
    public JSON getHallList() {
        try {
            List<MovieHall> movieHalls = movieHallRepository.findAll();
            return Response.success(movieHalls);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON updateHall(JSONObject req) {
        try {
            MovieHall movieHall = movieHallRepository.findByHallId(req.getString("hallId"));
            movieHall.setState(req.getBoolean("state"));
            movieHall.setName(req.getString("name"));
            movieHall.setRow(req.getInteger("row"));
            movieHall.setCol(req.getInteger("col"));
            movieHall.setCategory(req.getString("category"));
            movieHallRepository.save(movieHall);
            return Response.success(null);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON updateSlot(JSONObject req) {
        try {
            String slotId = req.getString("slotId");
            TimeSlot slot = timeSlotRepository.findTimeSlotBySlotId(slotId);
            //update
            slot.setHallId(req.getString("hallID"));
            slot.setMovieId(req.getString("movieId"));
            Date startTime = dateUtils.strToDate(req.getString("startTime"), DateStrPattern.SECONDS.getPat());
            Date endTime = dateUtils.strToDate(req.getString("endTime"), DateStrPattern.SECONDS.getPat());
            slot.setStartTime(startTime);
            slot.setEndTime(endTime);
            slot.setTicketPrize(req.getDouble("price"));
            timeSlotRepository.save(slot);
            return Response.success(null);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON newSlot(JSONObject req) {
        try {
            String slotId = req.getString("slotId");
            TimeSlot slot = new TimeSlot();
            //update
            if (timeSlotRepository.existsById(slotId)) {
                return Response.fail(ResponseType.RESOURCE_ALREADY_EXIST);
            }
            slot.setHallId(req.getString("hallID"));
            slot.setMovieId(req.getString("movieId"));
            Date startTime = dateUtils.strToDate(req.getString("startTime"), DateStrPattern.SECONDS.getPat());
            Date endTime = dateUtils.strToDate(req.getString("endTime"), DateStrPattern.SECONDS.getPat());
            slot.setStartTime(startTime);
            slot.setEndTime(endTime);
            slot.setTicketPrize(req.getDouble("price"));
            slot.setSlotId(idUtils.getUUID32());
            timeSlotRepository.save(slot);
            JSONObject ans = new JSONObject();
            ans.put("slotId", slot.getSlotId());
            return Response.success(ans);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON deleteSlot(String slotId) {
        try {
            timeSlotRepository.deleteById(slotId);
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON getRestSeats(String id) {
        try {
            TimeSlot slot = timeSlotRepository.findTimeSlotBySlotId(id);
            MovieHall hall = movieHallRepository.findByHallId(slot.getHallId());
            int row = hall.getRow();
            int col = hall.getCol();
            int[][] ans = new int[row][col];
            for (int[] i : ans) {
                Arrays.fill(i, 1);
            }
            List<MovieTicket> tickets =
                    movieTicketRepository.findMovieTicketsBySlotId(id);
            tickets.forEach(ticket -> {
                ans[ticket.getRow()][ticket.getCol()] = 0;
            });

            return Response.success(ans);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }

    }

}
