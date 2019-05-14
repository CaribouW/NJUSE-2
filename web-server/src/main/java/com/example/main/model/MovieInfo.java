package com.example.main.model;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movie_info", schema = "SE2", catalog = "")
public class MovieInfo implements Serializable {
    private String movieId; //id
    private String name;    //电影名
    private String nameEn;  //英文电影名
    private Date downDate;  //下架时间
    private Date uploadDate;//上架时间
    private Double score;   //得分
    private Integer timeLength;//放映时长(min)
    private String poster;  //电影海报(竖版)
    private String HPoster; //电影横版海报
    private String stills;  //剧照,用逗号隔开
    private String video;   //电影预告片url
    private String videoList; //视频列表,逗号隔开
    private Integer category;//类型,给予枚举类
    private String nation;  //国家
    private String lang;    //语言
    private String briefIntro;//简介
    private String hierarchical;//分级
    private String imdb;        //
    private String productionCompany; //出品公司
    private String distributionCompany; //发行公司
    private int state;     //上映状态,给予枚举类

    @Id
    @Column(name = "movie_id", length = 32)
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "down_date")
    public Date getDownDate() {
        return downDate;
    }

    public void setDownDate(Date downDate) {
        this.downDate = downDate;
    }

    @Basic
    @Column(name = "upload_date")
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Basic
    @Column(name = "score")
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "time_length")
    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }

    @Basic
    @Column(name = "poster")
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    @Basic
    @Column(name = "category")
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Basic
    @Column(name = "nation")
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "lang")
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieInfo movieInfo = (MovieInfo) o;
        return Objects.equals(movieId, movieInfo.movieId) &&
                Objects.equals(name, movieInfo.name) &&
                Objects.equals(downDate, movieInfo.downDate) &&
                Objects.equals(uploadDate, movieInfo.uploadDate) &&
                Objects.equals(score, movieInfo.score) &&
                Objects.equals(timeLength, movieInfo.timeLength) &&
                Objects.equals(poster, movieInfo.poster) &&
                Objects.equals(category, movieInfo.category) &&
                Objects.equals(nation, movieInfo.nation) &&
                Objects.equals(lang, movieInfo.lang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, name, downDate, uploadDate, score, timeLength, poster, category, nation, lang);
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "name_en")
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Basic
    @Column(name = "video")
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Basic
    @Column(name = "brief_intro")
    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
    }

    @Basic
    @Column(name = "hierarchical")
    public String getHierarchical() {
        return hierarchical;
    }

    public void setHierarchical(String hierarchical) {
        this.hierarchical = hierarchical;
    }

    @Basic
    @Column(name = "imdb")
    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @Basic
    @Column(name = "production_company")
    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    @Basic
    @Column(name = "distribution_company")
    public String getDistributionCompany() {
        return distributionCompany;
    }

    public void setDistributionCompany(String distributionCompany) {
        this.distributionCompany = distributionCompany;
    }

    @Basic
    @Column(name = "h_poster")
    public String getHPoster() {
        return HPoster;
    }

    public void setHPoster(String HPoster) {
        this.HPoster = HPoster;
    }

    @Basic
    @Column(name = "stills")
    public String getStills() {
        return stills;
    }

    public void setStills(String stills) {
        this.stills = stills;
    }

    @Basic
    @Column(name = "video_list")
    public String getVideoList() {
        return videoList;
    }

    public void setVideoList(String videoList) {
        this.videoList = videoList;
    }
}
