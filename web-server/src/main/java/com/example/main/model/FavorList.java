package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "favor_list", schema = "SE2", catalog = "")
public class FavorList implements Serializable {
    private String favorId;
    private String movieId;
    private String userId;
    private Date put_time;

    @Id
    @Column(name = "favor_id",length = 32,nullable = false)
    public String getFavorId() {
        return favorId;
    }

    public void setFavorId(String favorId) {
        this.favorId = favorId;
    }

    @Basic
    @Column(name = "movie_id")
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavorList favorList = (FavorList) o;
        return Objects.equals(favorId, favorList.favorId) &&
                Objects.equals(movieId, favorList.movieId) &&
                Objects.equals(userId, favorList.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(favorId, movieId, userId);
    }

    @Basic
    @Column(name = "put_time")
    public Date getPut_time() {
        return put_time;
    }

    public void setPut_time(Date put_time) {
        this.put_time = put_time;
    }
}
