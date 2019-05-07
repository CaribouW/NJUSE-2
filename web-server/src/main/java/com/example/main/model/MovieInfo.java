package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "movie_info", schema = "SE2", catalog = "")
public class MovieInfo implements Serializable {
    private String movieId;
    private String name;
    private Date downDate;
    private Date uploadDate;
    private Double score;
    private Integer timeLength;
    private String poster;
    private String director;
    private String editor;
    private String mainCharactor;
    private String category;
    private String nation;
    private String lang;

    @Id
    @Column(name = "movie_id",length = 32)
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
    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Basic
    @Column(name = "editor")
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Basic
    @Column(name = "main_charactor")
    public String getMainCharactor() {
        return mainCharactor;
    }

    public void setMainCharactor(String mainCharactor) {
        this.mainCharactor = mainCharactor;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
                Objects.equals(director, movieInfo.director) &&
                Objects.equals(editor, movieInfo.editor) &&
                Objects.equals(mainCharactor, movieInfo.mainCharactor) &&
                Objects.equals(category, movieInfo.category) &&
                Objects.equals(nation, movieInfo.nation) &&
                Objects.equals(lang, movieInfo.lang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, name, downDate, uploadDate, score, timeLength, poster, director, editor, mainCharactor, category, nation, lang);
    }
}
