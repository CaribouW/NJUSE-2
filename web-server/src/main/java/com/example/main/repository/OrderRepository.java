package com.example.main.repository;

import com.example.main.model.Order;

import java.util.List;

public interface OrderRepository extends BaseRepository<Order> {
    List<Order> findAllByUserId(String uid);
}
