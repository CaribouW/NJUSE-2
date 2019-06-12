package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.CrewRoleType;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.MovieCrew;
import com.example.main.model.MovieInfo;
import com.example.main.repository.FavorListRepository;
import com.example.main.repository.MovieCrewRepository;
import com.example.main.repository.MovieInfoRepository;
import com.example.main.repository.TimeSlotRepository;
import com.example.main.service.MovieService;
import com.example.main.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 主要职能:
 * 用户端——详细电影信息查看;想看电影操作;用户查看排片信息
 * 管理员端——电影上架管理;
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    private FavorListRepository favorListRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private MovieCrewRepository movieCrewRepository;
    @Autowired
    private DateUtils dateUtils;

    @Override
    public JSON getMovieFavorNum(String mid) {
        try {
            int sum = favorListRepository.findFavorListsByMovieId(mid).size();
            JSONObject ans = new JSONObject();
            ans.put("sum", sum);
            return Response.success(ans);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON getDetail(String mid, String uid) {
        try {
            MovieInfo movie = movieInfoRepository.findByMovieId(mid);
            if (null == movie) {
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
            }
            JSONObject ans = new JSONObject();
            ans.put("name", movie.getName());
            ans.put("pic", movie.getPoster());
            ans.put("video", movie.getVideo());
            ans.put("score", movie.getScore());
            ans.put("inFavorList",
                    favorListRepository.findFavorListByUserIdAndMovieId(uid, mid) != null);
            ans.put("favorNum",
                    favorListRepository.findFavorListsByMovieId(mid).size());
            ans.put("briefIntro", movie.getBriefIntro());
            //sub object
            JSONObject basicInfo = new JSONObject();
            basicInfo.put("ChineseName", movie.getName());
            basicInfo.put("EnglishName", movie.getNameEn());
            basicInfo.put("productionCompany", movie.getProductionCompany());
            basicInfo.put("distributionCompany", movie.getDistributionCompany());
            //dic
            basicInfo.put("director", "director");
            basicInfo.put("type", movie.getCategory());
            basicInfo.put("duration", movie.getTimeLength());
            basicInfo.put("showTime", dateUtils.dateToStr(movie.getUploadDate()));
            basicInfo.put("hierachical", movie.getHierarchical());
            basicInfo.put("pic", movie.getHPoster());
            basicInfo.put("language", movie.getLang());
            basicInfo.put("imdb", movie.getImdb());
            //ans put

            ans.put("basicInfo", basicInfo);
            return Response.success(ans);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON getPhoto(String mid) {
        MovieInfo movie = movieInfoRepository.findByMovieId(mid);
        if (null == movie)
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        try {
            JSONObject ans = new JSONObject();
            ans.put("photo", Arrays.asList(movie.getStills().split(",")));
            ans.put("video", Arrays.asList(movie.getVideoList().split(",")));
            return Response.success(ans);
        } catch (NullPointerException e) { //某一项不存在
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON getStaff(String mid) {
        try {
            List<MovieCrew> movieCrews = movieCrewRepository.findAllByMovieId(mid);
            JSONArray directorList = new JSONArray();
            JSONArray actorList = new JSONArray();
            JSONObject ans = new JSONObject();
            movieCrews.forEach(item -> {
                JSONObject object = new JSONObject();
                object.put("name", item.getName());
                object.put("pic", item.getAvatar());
                if (item.getRole().equals(CrewRoleType.ACTOR.getRole())) { //depend on the val
                    actorList.add(object);
                } else {
                    directorList.add(object);
                }
            });
            ans.put("directorList", directorList);
            ans.put("actorList", actorList);
            return Response.success(ans);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);

        }
    }

    @Override
    public JSON getAllMovies() {
        try {
            List<MovieInfo> movieInfos = movieInfoRepository.findAll();
            return Response.success(movieInfos);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }


}
