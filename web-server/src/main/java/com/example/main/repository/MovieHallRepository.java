package com.example.main.repository;

import com.example.main.model.MovieHall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieHallRepository extends BaseRepository<MovieHall> {
    Page<MovieHall> findMovieHallByHallId(String id, Pageable pageable);

    @Query(value = "select H.* from movie_hall H where H.hall_id in " +
            "(select t.hall_id from time_slot t where t.slot_id = :id)",nativeQuery = true)
    MovieHall findMovieHallBySlotId(@Param(value = "id") String id);

    MovieHall findByHallId(String hid);
}
