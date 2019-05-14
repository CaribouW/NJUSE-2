package com.example.main.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vip", schema = "SE2", catalog = "")
public class VIPCard implements Serializable {
    private String cardId;      //vip卡id
    private String userId;      //用户id
    private Double remainValue; //余额
    private Date ownDate;       //拥有时间
    private String vipLevel;    //vip等级

    @Id
    @Column(name = "id", length = 32)
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String memberId) {
        this.cardId = memberId;
    }

    @Basic
    @Column(name = "user_id", length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "remain_value")
    public Double getRemainValue() {
        return remainValue;
    }

    public void setRemainValue(Double remainValue) {
        this.remainValue = remainValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VIPCard that = (VIPCard) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(remainValue, that.remainValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, userId, remainValue);
    }

    @Basic
    @Column(name = "own_date")
    public Date getOwnDate() {
        return ownDate;
    }

    public void setOwnDate(Date ownDate) {
        this.ownDate = ownDate;
    }

    @Basic
    @Column(name = "vip_level")
    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }
}
