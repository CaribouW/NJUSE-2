package com.example.main.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 会员卡充值记录实体
 */
@Entity
@Table(name = "vip_recharge_history")
public class VIPRechargeHistory {
    private String vipId;
    private Date rechargeTime;
    private int amount;

    @Id
    @Column(name = "id", length = 32, columnDefinition = "vip id")
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
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
