package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_info", schema = "SE2", catalog = "")
public class UserInfo implements Serializable {
    private String userId;
    private String name;
    private int age;
    private String account;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return age == userInfo.age &&
                Objects.equals(userId, userInfo.userId) &&
                Objects.equals(name, userInfo.name) &&
                Objects.equals(account, userInfo.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, age, account);
    }
}
