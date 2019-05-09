package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "time_slot", schema = "SE2", catalog = "")
public class TimeSlot implements Serializable {
    private String slotId;  //场次
    private Date startTime; //开始时间
    private Date endTime;   //结束时间
    private String movieId; //movie id
    private Double ticketPrize; //票价(原价,和消费记录中的票价不一定一样)
    private String hallId;  //指定电影厅
    private String property;

    @Id
    @Column(name = "slot_id",length = 32)
    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date timeSlot) {
        this.startTime = timeSlot;
    }
    @Basic
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date timeSlot) {
        this.endTime = timeSlot;
    }
    @Basic
    @Column(name = "movie_id",length = 32)
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "ticket_prize")
    public Double getTicketPrize() {
        return ticketPrize;
    }

    public void setTicketPrize(Double ticketPrize) {
        this.ticketPrize = ticketPrize;
    }

    @Basic
    @Column(name = "hall_id",length = 32)
    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    @Basic
    @Column(name = "property")
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot1 = (TimeSlot) o;
        return Objects.equals(slotId, timeSlot1.slotId) &&
                Objects.equals(startTime, timeSlot1.startTime) &&
                Objects.equals(movieId, timeSlot1.movieId) &&
                Objects.equals(ticketPrize, timeSlot1.ticketPrize) &&
                Objects.equals(hallId, timeSlot1.hallId) &&
                Objects.equals(property, timeSlot1.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotId, startTime, movieId, ticketPrize, hallId, property);
    }
}
