package com.example.main.repository;

import com.example.main.model.MapperMovieCoupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MapperMovieCouponRepository extends BaseRepository<MapperMovieCoupon> {
    /**
     * 根据couponId获取到关联的电影id列表
     */
    @Query(value = "select m.movie_id from mapper_movie_coupon m where m.coupon_id =:cid", nativeQuery = true)
    List<MapperMovieCoupon> findMovieIdsByCouponId(@Param(value = "cid") String cid);
}
