package com.example.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vip_recharge_strategy")
public class VIPRechargeStrategy {
    private String id;
    private String rankName;    //会员级别名称
    private String rank;        //会员级别
    private double minRecharge; //初始充值最低值
    private double discount;    //减免的充值比例， 0 - 1

    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "discount")
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getMinRecharge() {
        return minRecharge;
    }

    public void setMinRecharge(double minRecharge) {
        this.minRecharge = minRecharge;
    }
}
