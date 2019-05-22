package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface HallService {
    /**
     * 得到所有排片信息
     */
    JSON getAllSlots();

    /**
     * 获取影厅信息
     */
    JSON getHallList();

    /**
     * 更新影厅信息
     */
    JSON updateHall(JSONObject req);

    //------------------------------------

    /**
     * 修改排片信息
     */
    JSON updateSlot(JSONObject req);

    /**
     * 添加排片信息
     */
    JSON newSlot(JSONObject req);

    /**
     * 删除排片信息
     */
    JSON deleteSlot(String slotId);
}
