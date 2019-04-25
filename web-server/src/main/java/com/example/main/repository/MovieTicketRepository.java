package com.example.main.repository;

import com.example.main.model.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTicketRepository extends JpaRepository<MovieTicket, String> {
}
