package com.example.main.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 消费记录实体
 */
@Entity
@Table(name = "expense_history")
public class ExpenseHistory {
    private String id;
    private String movie_id;
    private String user_id;
    private double expense;
    private Date time;
    private String orderNumber;

    @Id
    @Column(name = "id", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movie_id", length = 32)
    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    @Basic
    @Column(name = "user_id", length = 32)
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Basic
    @Column(name = "expense")
    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "order_number", columnDefinition = "订单号,根据id,time 哈希生成")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
