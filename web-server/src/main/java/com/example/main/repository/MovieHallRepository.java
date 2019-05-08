package com.example.main.repository;

import com.example.main.model.MovieHall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieHallRepository extends BaseRepository<MovieHall> {
    Page<MovieHall> findByMAndHallId(String id, Pageable pageable);
}
