package com.example.main.repository;

import com.example.main.model.User;
import com.example.main.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserInfoRepository extends BaseRepository<UserInfo> {
    UserInfo findUserInfoByUserId(String id);

    @Query(value = "select u.* from user_info u where u.user_id in (" +
            "select user_id from mapper_user_role mur inner join role r on mur.role_id = r.role_id and r.role_name = :role)", nativeQuery = true)
    List<UserInfo> findALLByRole(@Param(value = "role") String r);
}