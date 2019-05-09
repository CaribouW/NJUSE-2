package com.example.main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 剧组成员实体类
 */
@Entity
@Getter
@Setter
@Table(name = "cast_members")
public class CastMembers {
    private String movieId;
    private String director;

    @Id
    @Column(name = "id", length = 32)
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String id) {
        this.movieId = id;
    }

    @Basic
    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
