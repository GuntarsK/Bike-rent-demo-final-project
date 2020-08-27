package com.sda.bike.rent.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_pk")
    private Long reservationPk;

    @Column(name = "user_pk")
    private Long userPk;

    @Column(name = "bike_pk")
    private Long bikePk;

    @JsonFormat(pattern="dd.MM.yy")
    @Column(name = "date_from")
    private Date dateFrom;

    @JsonFormat(pattern="dd.MM.yy")
    @Column(name = "date_to")
    private Date dateTo;

    public Long getReservationPk() {
        return reservationPk;
    }

    public void setReservationPk(Long reservationPk) {
        this.reservationPk = reservationPk;
    }

    public Long getUserPk() {
        return userPk;
    }

    public void setUserPk(Long userPk) {
        this.userPk = userPk;
    }

    public Long getBikePk() {
        return bikePk;
    }

    public void setBikePk(Long bikePk) {
        this.bikePk = bikePk;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
