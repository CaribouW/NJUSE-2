package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "strategy_refund",schema = "SE2")
public class RefundStrategy implements Serializable {
    private String id;
    private String description;
    private String name;


    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
