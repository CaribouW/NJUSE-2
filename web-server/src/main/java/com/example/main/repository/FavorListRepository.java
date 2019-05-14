package com.example.main.repository;

import com.example.main.model.FavorList;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavorListRepository extends BaseRepository<FavorList> {
    /**
     * 根据movieId得到想看人数数量
     */
    List<FavorList> findFavorListsByMovieId(String movieId);

    /**
     * 根据userId得到所有相关的记录
     */
    List<FavorList> findAllByUserId(String uid);

    /**
     * 根据movieId , userId共同查询
     */
    FavorList findFavorListByUserIdAndMovieId(String uid, String mid);

    /**
     * 查询所有电影id,按照喜爱人数降序返回
     */
    @Query(value =
            "select ans.movie_id from (select f.movie_id,count(*) as c from favor_list f " +
                    "group by f.movie_id) as ans " +
                    "order by ans.c desc", nativeQuery = true)
    List<String> findMovieIdsMostFavorSorted();


}
