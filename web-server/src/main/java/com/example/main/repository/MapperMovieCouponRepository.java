package com.example.main.repository;

import com.example.main.model.MapperMovieCoupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MapperMovieCouponRepository extends BaseRepository<MapperMovieCoupon> {
    /**
     * 根据couponId获取到关联的电影id列表
     */
    List<MapperMovieCoupon> findAllByCouponId(String cid);
}
