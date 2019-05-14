package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.paging.PagingVO;
import com.example.main.core.response.Response;
import com.example.main.model.TimeSlot;
import com.example.main.repository.MovieHallRepository;
import com.example.main.repository.MovieTicketRepository;
import com.example.main.repository.TimeSlotRepository;
import com.example.main.service.HallService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
    public JSON getAllSchedule() {

        return null;
    }

    @Override
    public JSON adminAllSchedule() {
        try {
            List<TimeSlot> list = timeSlotRepository.findAll();
            //按照时间由小到大
            list.sort(Comparator.comparing(TimeSlot::getStartTime));
            JSONArray array = new JSONArray();
            list.forEach(item -> {
                JSONObject object = new JSONObject();

                object.put("startTime", dateUtils.dateToStr(item.getStartTime()));
                object.put("endTime", dateUtils.dateToStr(item.getEndTime()));

            });
            JSONObject ans = new JSONObject();
            //put arr
            ans.put("slot", array);

            return Response.success(ans);

        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }


}
