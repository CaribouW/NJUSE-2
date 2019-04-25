package com.example.main.repository;

import com.example.main.model.FavorList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorListRepository extends JpaRepository<FavorList, String> {
}
