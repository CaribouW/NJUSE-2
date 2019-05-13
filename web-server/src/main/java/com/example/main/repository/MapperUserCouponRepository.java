package com.example.main.repository;

import com.example.main.model.MapperUserCoupon;

import java.util.List;

public interface MapperUserCouponRepository extends BaseRepository<MapperUserCoupon> {
    /**
     * 根据userId获取个人关联的优惠券列表
     */
    List<MapperUserCoupon> findMapperUserCouponsByUserId(String uid);

    /**
     * 根据主键获取个人关联的优惠券
     */
    MapperUserCoupon findMapperUserCouponById(String ucId);

    /**
     * 根据couponId获取个人关联的优惠券列表
     */
    List<MapperUserCoupon> findMapperUserCouponsByCouponId(String cId);
}
