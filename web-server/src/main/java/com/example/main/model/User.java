package com.example.main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User implements Serializable {
    @Id
    @Column(name = "user_id", nullable = false, length = 30)
    private String userId;
    @Column(name = "password")
    private String password;

    public User(String userId) {
        this.userId = userId;
    }

    public User() {
    }
}
