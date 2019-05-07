package com.example.main.repository;

import com.example.main.model.FavorList;

import java.util.List;

public interface FavorListRepository extends BaseRepository<FavorList> {
    /**
     * 根据movieId得到想看人数数量
     */
    List<FavorList> findFavorListsByMovieId(String movieId);

}
