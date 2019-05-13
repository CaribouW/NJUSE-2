package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * 优惠券实体类
 * 给予用户，和用户连接(优惠策略里面的不一样)
 */
@Entity
@Table(name = "strategy_coupon", schema = "SE2")
public class Coupon implements Serializable {
    private String couponId;    //id
    private String name;        //名称
    private Date startDate;     //开始时间
    private Date endDate;       //结束(过期)时间
    private int amount;         //总量
    private int discount;       //减价
    private int threshHold;     //满减阈值

    @Id
    @Column(name = "coupon_id", length = 32)
    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String preferentialId) {
        this.couponId = preferentialId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "discount")
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon that = (Coupon) o;
        return Objects.equals(couponId, that.couponId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponId, name, startDate, endDate);
    }

    @Basic
    @Column(name = "threshHold")
    public int getThreshHold() {
        return threshHold;
    }

    public void setThreshHold(int threshHold) {
        this.threshHold = threshHold;
    }
}
