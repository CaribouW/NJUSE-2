package com.example.main.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "preferential")
public class Preferential {
    private String preferentialId;
    private String name;
    private Date startDate;
    private Date endDate;

    @Id
    @Column(name = "preferential_id")
    public String getPreferentialId() {
        return preferentialId;
    }

    public void setPreferentialId(String preferentialId) {
        this.preferentialId = preferentialId;
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
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preferential that = (Preferential) o;
        return Objects.equals(preferentialId, that.preferentialId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferentialId, name, startDate, endDate);
    }
}
