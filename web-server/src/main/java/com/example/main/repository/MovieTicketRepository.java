package com.example.main.repository;

import com.example.main.model.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieTicketRepository extends BaseRepository<MovieTicket> {
    /**
     * 得到给定场次的已锁定座位电影票列表
     */
    List<MovieTicket> findMovieTicketsBySlotId(String slotId);

    /**
     * 得到给定userid 的电影票列表
     */
    List<MovieTicket> findMovieTicketsByUserId(String userId);
}
