package com.example.main.dao;


import com.example.main.model.User;
public interface UserDao {
    User psw(String uid);

    int selectByKey(String uid);
}
