package com.example.main.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "time_slot", schema = "SE2", catalog = "")
public class TimeSlot {
    private String slotId;
    private Timestamp timeSlot;
    private String movieId;
    private Double ticketPrize;
    private String hallId;
    private String property;

    @Id
    @Column(name = "slot_id")
    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    @Basic
    @Column(name = "time_slot")
    public Timestamp getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Timestamp timeSlot) {
        this.timeSlot = timeSlot;
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
    @Column(name = "ticket_prize")
    public Double getTicketPrize() {
        return ticketPrize;
    }

    public void setTicketPrize(Double ticketPrize) {
        this.ticketPrize = ticketPrize;
    }

    @Basic
    @Column(name = "hall_id")
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
                Objects.equals(timeSlot, timeSlot1.timeSlot) &&
                Objects.equals(movieId, timeSlot1.movieId) &&
                Objects.equals(ticketPrize, timeSlot1.ticketPrize) &&
                Objects.equals(hallId, timeSlot1.hallId) &&
                Objects.equals(property, timeSlot1.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotId, timeSlot, movieId, ticketPrize, hallId, property);
    }
}
