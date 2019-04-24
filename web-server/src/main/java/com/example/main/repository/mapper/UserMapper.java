package com.example.main.repository.mapper;

import com.example.main.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserById();
}
