package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "strategy_refund", schema = "SE2")
public class RefundStrategy implements Serializable {
    private String id;
    private float limitTime;
    private float rate;

    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "limit_time")
    public float getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(float limitTime) {
        this.limitTime = limitTime;
    }

    @Basic
    @Column(name = "rate")
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
