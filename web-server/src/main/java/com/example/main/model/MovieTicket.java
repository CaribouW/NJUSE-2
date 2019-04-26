package com.example.main.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_ticket", schema = "SE2", catalog = "")
public class MovieTicket {
    private String ticketId;
    private String veriCode;
    private String slotId;
    private String position;
    private String preferentialId;
    private String userId;
    private int status;

    @Id
    @Column(name = "ticket_id")
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "veri_code")
    public String getVeriCode() {
        return veriCode;
    }

    public void setVeriCode(String veriCode) {
        this.veriCode = veriCode;
    }

    @Basic
    @Column(name = "slot_id")
    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "preferential_id")
    public String getPreferentialId() {
        return preferentialId;
    }

    public void setPreferentialId(String preferentialId) {
        this.preferentialId = preferentialId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieTicket that = (MovieTicket) o;
        return Objects.equals(ticketId, that.ticketId) &&
                Objects.equals(veriCode, that.veriCode) &&
                Objects.equals(slotId, that.slotId) &&
                Objects.equals(position, that.position) &&
                Objects.equals(preferentialId, that.preferentialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, veriCode, slotId, position, preferentialId);
    }
}
