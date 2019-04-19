package com.example.main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User implements Serializable {
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password")
    private String password;

    @ManyToMany()
    @JoinTable(name = "mapper_user_role", joinColumns = {
            @JoinColumn(name = "user_id", foreignKey =
            @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)),
    }, inverseJoinColumns = {
            @JoinColumn(name = "role_id", foreignKey =
            @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    })
    private List<Role> roles;

    public User(String userId) {
        this.userId = userId;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
