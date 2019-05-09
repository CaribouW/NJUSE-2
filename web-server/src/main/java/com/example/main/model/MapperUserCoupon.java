package com.example.main.model;

import javax.persistence.*;

/**
 * 用户-优惠券
 * 多对多中间表
 */
@Entity
@Table(name = "mapper_user_coupon")
public class MapperUserCoupon {
    private String id;
    private String userId;
    private String couponId;

    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String user_id) {
        this.userId = user_id;
    }

    @Basic
    @Column(name = "coupon_id", length = 32)
    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String coupon_id) {
        this.couponId = coupon_id;
    }
}
