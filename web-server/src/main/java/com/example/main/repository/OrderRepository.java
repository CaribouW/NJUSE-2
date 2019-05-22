package com.example.main.repository;

import com.example.main.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderRepository extends BaseRepository<Order> {
    List<Order> findAllByUserId(String uid);

    Order findOrderByOrderId(String oid);

    Order findOrderByUserIdAndOrderId(String uid, String oid);
}
