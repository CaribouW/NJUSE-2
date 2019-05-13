package com.example.main.model;

import javax.persistence.*;

@Entity
@Table(name = "mapper_movie_coupon")
public class MapperMovieCoupon {
    private String id;
    private String movieId;
    private String couponId;

    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movie_id", length = 32)
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "coupon_id", length = 32)
    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }


}
