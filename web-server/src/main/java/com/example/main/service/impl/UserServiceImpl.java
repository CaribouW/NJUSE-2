package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.DateStrPattern;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.FavorList;
import com.example.main.model.User;
import com.example.main.model.UserInfo;
import com.example.main.repository.FavorListRepository;
import com.example.main.repository.UserInfoRepository;
import com.example.main.repository.UserRepository;
import com.example.main.service.UserService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import netscape.javascript.JSObject;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户个人信息的操作
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private FavorListRepository favorListRepository;
    @Autowired
    private IDUtils idUtils;
    @Autowired
    private DateUtils dateUtils;

    @Override
    public JSON postFavor(String userId, String movieId) {
        FavorList favorList = new FavorList();
        try {
            FavorList tmp = favorListRepository
                    .findFavorListByUserIdAndMovieId(userId, movieId);
            if (null != tmp) {
                return Response.fail(ResponseType.RESOURCE_ALREADY_EXIST);
            }
            //添加信息
            favorList.setFavorId(idUtils.getUUID32());
            favorList.setUserId(userId);
            favorList.setMovieId(movieId);
            favorList.setPut_time(new Date());
            //store
            favorListRepository.save(favorList);
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON deleteFavor(String userId, String movieId) {
        try {
            FavorList favorList = favorListRepository
                    .findFavorListByUserIdAndMovieId(userId, movieId);
            if (null == favorList) { //资源不存在
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
            } else {
                favorListRepository.delete(favorList);
                return Response.success(null);
            }
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON getUserInfo(String uid) {
        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(uid);
        if (null == userInfo) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        }
        JSONObject ans = new JSONObject();
        try {
            ans.put("name", userInfo.getName());
            ans.put("pic", userInfo.getAvatarUrl());
            ans.put("id", uid);
            ans.put("vip", "vip");
            ans.put("birthday", dateUtils.dateToStr(userInfo.getBirth() == null ? new Date() : userInfo.getBirth()));
            ans.put("sex", userInfo.getSex().equals("male") ? 1 : 0);
            return Response.success(ans);
        } catch (Exception e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        }

    }

    @Override
    public JSON modifyInfo(JSONObject req) {
        String uid = req.getString("id");
        try {
            UserInfo userInfo = userInfoRepository.findUserInfoByUserId(uid);
            if (null == userInfo) { //账户不存在
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
            } else {
                JSONObject tmp = req.getJSONObject("info");
                String sex = tmp.getInteger("sex") == 1 ? "male" : "female";
                Date birth = dateUtils.strToDate(tmp.getString("birthday"),
                        DateStrPattern.YEAR_MONTH_DAY.getPat());
                userInfo.setName(tmp.getString("name"));
                userInfo.setAvatarUrl(tmp.getString("pic"));
                userInfo.setBirth(birth);
                userInfo.setSex(sex);
                userInfoRepository.saveAndFlush(userInfo);
                return Response.success(null);
            }
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

}
