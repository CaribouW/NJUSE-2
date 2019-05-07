package com.example.main.service.impl;

import com.example.main.repository.MemberListRepository;
import com.example.main.repository.PreferentialRepository;
import com.example.main.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 会员相关;
 * 普通用户:会员卡充值购买;查看
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberListRepository memberListRepository;

    @Autowired
    private PreferentialRepository preferentialRepository;
}
