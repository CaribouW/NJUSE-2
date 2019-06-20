package com.example.main.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 会员卡充值记录实体
 */
@Entity
@Table(name = "vip_recharge_history")
public class VIPRechargeHistory {
    private String id;
    private String vipId;
    private Date rechargeTime;  //退还时间
    private double amount;      //退还额度

    @Id
    @Column(name = "id", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "vip_id", length = 32)
    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    @Basic
    @Column(name = "recharge_time")
    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    @Basic
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
