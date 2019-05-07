package com.example.main.repository;

import com.example.main.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieInfoRepository extends BaseRepository<MovieInfo> {
    /**
     * 通过user id 得到想看电影列表
     */
    @Query(value = "select movie.* from" +
            " (select f.movie_id from favor_list f where :uid = f.user_id) as mid " +
            "inner join movie_info movie on movie.movie_id = mid.movie_id",
            nativeQuery = true)
    List<MovieInfo> findMovieByUserId(@Param("uid") String uid);

    /**
     * 通过电影场次得到电影
     * */
}
