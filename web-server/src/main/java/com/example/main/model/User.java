package com.example.main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User implements Serializable {
    private String userId;
    private String password;

    @Id
    @Column(name = "user_id", length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(password, user.password);
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User() {
    }

    public User(String id, String psw) {
        this.userId = id;
        this.password = psw;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password);
    }
}
