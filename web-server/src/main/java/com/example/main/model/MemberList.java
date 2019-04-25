package com.example.main.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "member_list", schema = "SE2", catalog = "")
public class MemberList {
    private String memberId;
    private String userId;
    private Double remainValue;
    private String cardNumber;

    @Id
    @Column(name = "member_id")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "user_id")
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

    @Basic
    @Column(name = "card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberList that = (MemberList) o;
        return Objects.equals(memberId, that.memberId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(remainValue, that.remainValue) &&
                Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, userId, remainValue, cardNumber);
    }
}
