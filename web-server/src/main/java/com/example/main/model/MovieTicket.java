package com.example.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "movie_ticket", schema = "SE2", catalog = "")
public class MovieTicket implements Serializable {
    private String ticketId;//ticketId
    private String slotId;  //场次
    //    private String position;//座位
    private int row;
    private int col;
    //    private double price;   //实际付款
    private String orderId;//ticketId


    @Id
    @Column(name = "ticket_id", length = 32)
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "slot_id", length = 32)
    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieTicket that = (MovieTicket) o;
        return Objects.equals(ticketId, that.ticketId) &&
                Objects.equals(slotId, that.slotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, slotId, row, col);
    }


    @Basic
    @Column(name = "order_id", length = 32)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Column(name = "row")
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Column(name = "col")
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
