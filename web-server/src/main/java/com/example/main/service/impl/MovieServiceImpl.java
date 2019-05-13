package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.repository.FavorListRepository;
import com.example.main.repository.MovieInfoRepository;
import com.example.main.repository.TimeSlotRepository;
import com.example.main.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
