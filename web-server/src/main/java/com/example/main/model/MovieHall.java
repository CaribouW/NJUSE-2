package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "movie_hall", schema = "SE2", catalog = "")
public class MovieHall implements Serializable {
    private String hallId;
    private String hallName;    //影厅名
    private int row;
    private int col;
    private String category;    //类型
    private boolean state;          //是否可用

    @Id
    @Column(name = "hall_id",length = 32)
    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    @Basic
    @Column(name = "hall_name")
    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }


    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieHall movieHall = (MovieHall) o;
        return Objects.equals(hallId, movieHall.hallId) &&
                Objects.equals(hallName, movieHall.hallName) &&
                Objects.equals(category, movieHall.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hallId, hallName, category);
    }

    @Basic
    @Column(name = "state")
    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Column(name = "row_num")
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Column(name = "col_num")
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
