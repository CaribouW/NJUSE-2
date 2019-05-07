package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "vip", schema = "SE2", catalog = "")
public class VIPCard implements Serializable {
    private String cardId;
    private String userId;
    private Double remainValue;
    private String cardNumber;

    @Id
    @Column(name = "id",length = 32)
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String memberId) {
        this.cardId = memberId;
    }

    @Basic
    @Column(name = "user_id",length = 32)
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
        VIPCard that = (VIPCard) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(remainValue, that.remainValue) &&
                Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, userId, remainValue, cardNumber);
    }
}
