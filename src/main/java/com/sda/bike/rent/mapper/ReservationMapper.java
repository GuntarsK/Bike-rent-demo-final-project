package com.sda.bike.rent.mapper;

import com.sda.bike.rent.dto.ReservationDTO;
import com.sda.bike.rent.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation fromDTO(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();

        reservation.setReservationPk(reservationDTO.getReservationPk());
        reservation.setUserPk(reservationDTO.getUserPk());
        reservation.setBikePk(reservationDTO.getBikePk());
        reservation.setDateFrom(reservationDTO.getDateFrom());
        reservation.setDateTo(reservationDTO.getDateTo());

        return reservation;
    }

    public ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setReservationPk(reservation.getReservationPk());
        reservationDTO.setUserPk(reservation.getUserPk());
        reservationDTO.setBikePk(reservation.getBikePk());
        reservationDTO.setDateFrom(reservation.getDateFrom());
        reservationDTO.setDateTo(reservation.getDateTo());

        return reservationDTO;
    }


}
