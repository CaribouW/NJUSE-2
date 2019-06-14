package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.CrewRoleType;
import com.example.main.core.enums.DateStrPattern;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.FavorList;
import com.example.main.model.MovieCrew;
import com.example.main.model.MovieInfo;
import com.example.main.model.UserInfo;
import com.example.main.repository.FavorListRepository;
import com.example.main.repository.MovieCrewRepository;
import com.example.main.repository.MovieInfoRepository;
import com.example.main.repository.UserInfoRepository;
import com.example.main.service.UserService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户个人信息的操作
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private FavorListRepository favorListRepository;
    @Autowired
    private MovieCrewRepository movieCrewRepository;
    @Autowired
    private MovieInfoRepository movieInfoRepository;
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
            if (!userInfoRepository.existsById(userId) ||
                    !movieInfoRepository.existsById(movieId)) {
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
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

    @Override
    public JSON getUserFavorMovie(String uid) {
        try {
            //得到相关联的电影
            List<MovieInfo> movies = movieInfoRepository.findMovieByUserId(uid);
            List<String> targetFavor =
                    favorListRepository.findAllByUserId(uid)
                            .stream()
                            .map(FavorList::getMovieId)
                            .collect(Collectors.toList());

            movies = movies.stream()
                    .filter(item -> targetFavor.contains(item.getMovieId()))
                    .collect(Collectors.toList());
            JSONObject ans = new JSONObject();
            JSONArray favorList = new JSONArray();
            movies.forEach(item -> {
                JSONObject object = new JSONObject();
                object.put("movieId", item.getMovieId());
                object.put("movieName", item.getName());
                object.put("releaseDate", dateUtils.dateToStr(item.getUploadDate()));
                object.put("releaseArea", item.getNation());
                object.put("imgURL", item.getPoster());
                //get all crews
                List<MovieCrew> movieCrews = movieCrewRepository.findAllByMovieId(item.getMovieId())
                        .stream()
                        .filter(it -> it.getRole().equals(CrewRoleType.ACTOR.getRole()))
                        .collect(Collectors.toList());
                //put name
                object.put("mainActor", movieCrews.stream()
                        .map(MovieCrew::getName)
                        .collect(Collectors.toList()));
                favorList.add(object);
            });

            ans.put("favorList", favorList);
            return Response.success(ans);
        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

}
