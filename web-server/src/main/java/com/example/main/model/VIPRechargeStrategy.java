package com.example.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vip_recharge_strategy")
public class VIPRechargeStrategy {
    private String id;
    private double amount;
    private double discount;

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

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
}
