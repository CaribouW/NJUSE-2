package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.DateStrPattern;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.VIPCard;
import com.example.main.model.VIPRechargeHistory;
import com.example.main.model.VIPRechargeStrategy;
import com.example.main.repository.*;
import com.example.main.service.VIPService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private VIPRechargeStrategyRepo vipRechargeStrategyRepo;
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
            //recharge His
            VIPRechargeHistory history = new VIPRechargeHistory();
            history.setVipId(vipCard.getCardId());
            history.setRechargeTime(new Date());
            history.setAmount(cardBalance);
            history.setId(idUtils.getUUID32());
            historyRepository.save(history);
            //response
            JSONObject res = new JSONObject();
            res.put("VIPCardId", vipCard.getCardId());
            VIPRechargeStrategy strategy = getVipLevel(uid);
            res.put("VIPLevel", strategy.getRankName());
            res.put("discount", strategy.getDiscount());
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
            //获取指定策略
            VIPRechargeStrategy strategy = getVipLevel(uid);
            JSONObject res = new JSONObject();
            res.put("VIPCardId", vipCard.getCardId());
            res.put("VIPCardBalance", vipCard.getRemainValue());
            res.put("VIPLevel", strategy.getRankName());
            res.put("discount", strategy.getDiscount());
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
        try {
            VIPCard vipCard =
                    vipCardRepository.findVIPCardByCardId(id);
            if (null == vipCard) {
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
            }
            VIPRechargeStrategy strategy = getVipLevel(vipCard.getUserId());
            //update remain
            vipCard.setRemainValue(amount / strategy.getDiscount() + vipCard.getRemainValue());
            //insert history
            VIPRechargeHistory history = new VIPRechargeHistory();
            history.setId(idUtils.getUUID32());
            history.setAmount(amount / strategy.getDiscount());
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
    public JSON findAllVipCards(double limitation) {
        try {
            List<VIPCard> vipCards = vipCardRepository.findAll().stream()
                    .filter(item -> {
                        String id = item.getCardId();
                        item.setVipLevel(getVipLevel(item.getUserId()).getRankName());
                        double value = historyRepository.findAllByVipId(id)
                                .stream()
                                .map(VIPRechargeHistory::getAmount).reduce((v1, v2) -> v1 + v2).get();
                        return value >= limitation;
                    }).collect(Collectors.toList());

            return Response.success(vipCards);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }

    }

    private VIPRechargeStrategy getVipLevel(String uid) {
        double amount = fetchRechargeAmount(uid);
        List<VIPRechargeStrategy> strategys = vipRechargeStrategyRepo.findAll();
        strategys.sort((o1, o2) -> (int) (o1.getMinRecharge() - o2.getMinRecharge()));
        for (VIPRechargeStrategy strategy : strategys) {
            if (strategy.getMinRecharge() >= amount) {
                return strategy;
            }
        }
        //否则返回最高的
        return strategys.get(strategys.size() - 1);
    }

    private double fetchRechargeAmount(String uid) {
        return
                historyRepository.findAllByUserId(uid)
                        .stream()
                        .map(VIPRechargeHistory::getAmount)
                        .reduce(Double::sum).get();
    }
}
