package com.example.main.service;

import com.example.main.repository.PreferentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 经理策略制定
 * 包括了管理会员策略,退票策略,优惠活动用例内容
 */
@Service
public class StrategyService {
    @Autowired
    private PreferentialRepository preferentialRepository;
}