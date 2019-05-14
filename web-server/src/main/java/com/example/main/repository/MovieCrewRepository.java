package com.example.main.repository;

import com.example.main.model.MovieCrew;

import java.util.List;

public interface MovieCrewRepository extends BaseRepository<MovieCrew> {
    List<MovieCrew> findAllByMovieId(String mid);
}
