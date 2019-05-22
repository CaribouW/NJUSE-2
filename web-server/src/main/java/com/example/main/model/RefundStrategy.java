package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "strategy_refund",schema = "SE2")
public class RefundStrategy implements Serializable {
    private String id;

    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
