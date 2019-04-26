package com.example.main.service;

import com.example.main.repository.MemberListRepository;
import com.example.main.repository.PreferentialRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 会员相关;
 * 普通用户:会员卡充值购买;查看
 */
public class MemberService {
    @Autowired
    private MemberListRepository memberListRepository;

    @Autowired
    private PreferentialRepository preferentialRepository;
}
