package com.example.main.repository;

import com.example.main.model.VIPCard;

public interface VIPCardRepository extends BaseRepository<VIPCard> {
    /**
     * 通过userId得到
     */
    VIPCard findByUserId(String uid);

}
