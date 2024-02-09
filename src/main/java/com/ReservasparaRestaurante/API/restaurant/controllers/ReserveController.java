package com.ReservasparaRestaurante.API.restaurant.controllers;

import com.ReservasparaRestaurante.API.restaurant.dto.reserve.CreateReserveDto;
import com.ReservasparaRestaurante.API.restaurant.dto.reserve.CreateReserveDtoToUpdate;
import com.ReservasparaRestaurante.API.restaurant.entities.ReserveEntity;
import com.ReservasparaRestaurante.API.restaurant.services.ReserveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReserveController {

    private final ReserveService reserveService;

    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewReservation(@RequestBody CreateReserveDto request) {
        try {
            ReserveEntity newReservation = reserveService.createNewReservation(
                    request.getCustomerName(),
                    request.getCustomerNumber(),
                    request.getDateReserve(),
                    true,
                    "COMPLETED",
                    null
            );
            return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReserveEntity>> getAllReservations() {
        List<ReserveEntity> reservations = reserveService.getAllReservation();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        Object reservation = reserveService.getReservationById(id);
        if (reservation instanceof ReserveEntity) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(reservation.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateReservationById(@RequestBody CreateReserveDtoToUpdate request, @PathVariable Long id) {
        try {
            ReserveEntity updatedReservation = reserveService.updateById(request, id);
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") Long id) {
        try {
            String reservationDeleted = reserveService.deleteReservationById(id);
            return ResponseEntity.ok(reservationDeleted);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }}


