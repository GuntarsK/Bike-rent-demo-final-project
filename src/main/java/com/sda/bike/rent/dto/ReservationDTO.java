package com.sda.bike.rent.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ReservationDTO {

    @JsonProperty("reservation_pk")
    private Long reservationPk;

    @JsonProperty("user_pk")
    private Long userPk;

    @JsonProperty("bike_pk")
    private Long bikePk;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonProperty("date_from")
    private Date dateFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonProperty("date_to")
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
