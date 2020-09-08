package com.sda.bike.rent.controller;

import com.sda.bike.rent.dto.ReservationDTO;
import com.sda.bike.rent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rest/reservation.svc")
@CrossOrigin
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservation")
    public ReservationDTO createReservation(@Valid @RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    @GetMapping("/reservation")
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/reservation({pk})")
    public ReservationDTO getReservationById(@PathVariable("pk") Long pk) {
        return reservationService.getReservationById(pk);
    }

    @PostMapping("/reservation/search")
    public List<ReservationDTO> search(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.search(reservationDTO);
    }

    @PutMapping("/reservation")
    public void updateReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.updateReservation(reservationDTO);
    }


}
