package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "strategy_vip")
public class VIPStrategy implements Serializable {
    private String id;
    private String rankName;    //会员级别名称
    private String rank;        //会员级别
    private double minRecharge; //初始充值最低值
    private int rankLevel;      //rank 等级,整数
    private double discount;    //

    @Id
    @Column(name = "id", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "min_recharge")
    public double getMinRecharge() {
        return minRecharge;
    }

    public void setMinRecharge(double minRecharge) {
        this.minRecharge = minRecharge;
    }

    @Basic
    @Column(name = "rank_level")
    public int getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(int rankLevel) {
        this.rankLevel = rankLevel;
    }

    @Basic
    @Column(name = "discount")
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "rank_name")
    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    @Basic
    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
