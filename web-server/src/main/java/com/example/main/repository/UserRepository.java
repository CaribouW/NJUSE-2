package com.example.main.repository;

import com.example.main.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends BaseRepository<User> {
    @Query(value = "select * from user u join user_info ui on u.user_id = ui.user_id where ui.account = :account", nativeQuery = true)
    User findUserByAccount(@Param(value = "account") String account);

    User findUserByUserId(String userID);


}
