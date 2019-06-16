package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.DateStrPattern;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.VIPCard;
import com.example.main.model.VIPRechargeHistory;
import com.example.main.repository.CouponRepository;
import com.example.main.repository.VIPCardRepository;
import com.example.main.repository.VIPRechargeHistoryRepository;
import com.example.main.service.VIPService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 会员相关;
 * 普通用户:会员卡充值购买;查看
 */
@Service
public class VIPServiceImpl implements VIPService {

    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private VIPCardRepository vipCardRepository;
    @Autowired
    private VIPRechargeHistoryRepository historyRepository;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private IDUtils idUtils;

    @Override
    public JSON addVipCard(JSONObject req) {
        String uid = req.getString("userId");
        double cardBalance = req.getDouble("cardBalance");
        String ownDate = req.getString("ownDate");
        VIPCard vipCard = new VIPCard();
        try {
            if (null != vipCardRepository.findByUserId(uid)) { //vip卡已存在
                return Response.fail(ResponseType.RESOURCE_ALREADY_EXIST);
            }
            vipCard.setCardId(idUtils.getUUID32());
            vipCard.setUserId(uid);
            vipCard.setOwnDate(dateUtils.strToDate(ownDate, DateStrPattern.YEAR_MONTH_DAY.getPat()));
            vipCard.setRemainValue(cardBalance);
            //save
            vipCardRepository.save(vipCard);
            //response
            JSONObject res = new JSONObject();
            res.put("VIPCardId", vipCard.getCardId());
            res.put("VIPLevel", "VIP");
            return Response.success(res);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON findVipByUid(String uid) {
        try {
            VIPCard vipCard = vipCardRepository.findByUserId(uid);
            if (null == vipCard) {
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
            }
            JSONObject res = new JSONObject();
            res.put("VIPCardId", vipCard.getCardId());
            res.put("VIPCardBalance", vipCard.getRemainValue());
            res.put("VIPLevel", vipCard.getVipLevel());
            res.put("ownDate", vipCard.getOwnDate());
            return Response.success(res);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON recharge(JSONObject req) {
        double amount = req.getDouble("rechargeAmount");
        String id = req.getString("VIPCardId");
//        String rechargeTime = req.getString("rechargeTime");
        try {
            VIPCard vipCard =
                    vipCardRepository.findVIPCardByCardId(id);
            if (null == vipCard) {
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
            }
            //update remain
            vipCard.setRemainValue(amount + vipCard.getRemainValue());
            //insert history
            VIPRechargeHistory history = new VIPRechargeHistory();
            history.setId(idUtils.getUUID32());
            history.setAmount(amount);
            history.setRechargeTime(new Date());
            history.setVipId(id);
            //save
            historyRepository.save(history);
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON consume(JSONObject req) {
        return null;
    }

    @Override
    public JSON findHistoryListByUid(String uid) {
        try {
            List<VIPRechargeHistory> list = historyRepository.findAllByUserId(uid);
            JSONArray array = new JSONArray();
            list.forEach(item -> {
                JSONObject object = new JSONObject();
                object.put("time", item.getRechargeTime());
                object.put("amount", item.getAmount());
                array.add(object);
            });
            JSONObject ans = new JSONObject();
            ans.put("rechargeList", array);
            return Response.success(ans);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON findAllVipCards() {
        return Response.success(vipCardRepository.findAll());
    }
}
