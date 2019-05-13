package com.example.main.repository;

import com.example.main.model.UserInfo;

public interface UserInfoRepository extends BaseRepository<UserInfo> {
    UserInfo findUserInfoByUserId(String id);
}