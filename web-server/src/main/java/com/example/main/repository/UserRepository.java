package com.example.main.repository;

import com.example.main.model.Role;
import com.example.main.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findTop1ByUserId(String uid);

    @Transactional
    @Query("select u from User u where u.userId=?1")
    User findUserByUserId(String userid);

    @Transactional
    @Modifying
    @Query("delete from User where userId = ?1")
    void deleteByUserId(String userid);

    @Transactional
    @Query("select r from () where userId = ?1")
    List<Role> findRolesByUserId(String uid);
}
