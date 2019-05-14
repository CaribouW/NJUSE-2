package com.example.main.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单实体
 */
@Entity
@Table(name = "order_user")
public class Order {
    private String orderId; //id
    private String userId;  //用户绑定订单
    private Date confirmDate;//付款确认时间
    private double expense; //花费
    private int state;      //订单状态 0--正常，1--已退票，2--未支付(未超时)，3--支付超时

    @Id
    @Column(name = "order_id", length = 32)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
    @Column(name = "confirm_date")
    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "expense")
    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }
}
