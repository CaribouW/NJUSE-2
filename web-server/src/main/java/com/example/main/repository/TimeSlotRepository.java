package com.example.main.repository;

import com.example.main.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;

public interface TimeSlotRepository extends BaseRepository<TimeSlot> {
    TimeSlot findTimeSlotBySlotId(String sid);

    /**
     * 根据movie_id 得到所有相关场次
     */
    @Query(value = "select T.* from time_slot T WHERE T.movie_id = :mid;", nativeQuery = true)
    List<TimeSlot> findTimeSlotByMovieId(@Param("mid") String movieId);

    /**
     * 根据movie name 得到所有相关场次
     */
    @Query(value = "select T.* from time_slot T WHERE T.movie_id in (select m.movie_id from movie_info m where m.name = name);", nativeQuery = true)
    List<TimeSlot> findTimeSlotByMovieName(@Param("name") String movieId);

    @Query(value = "select T.* from time_slot T where T.slot_id in (select m.slot_id from movie_ticket m  where m.ticket_id = :ticketId)", nativeQuery = true)
    TimeSlot findTimeSlotByTicketId(@Param("ticketId") String ticketId);

    List<TimeSlot> findAllByHallId(String hid);
}
