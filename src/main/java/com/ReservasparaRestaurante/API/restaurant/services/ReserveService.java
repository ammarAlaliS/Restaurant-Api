package com.ReservasparaRestaurante.API.restaurant.services;

import com.ReservasparaRestaurante.API.restaurant.entities.MenuEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.ReserveEntity;
import com.ReservasparaRestaurante.API.restaurant.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {
    private final ReservaRepository reservaRepository;
    private final MenuService menuService;

    @Autowired
    public ReserveService(ReservaRepository reservaRepository, MenuService menuService) {
        this.reservaRepository = reservaRepository;
        this.menuService = menuService;
    };

    public ReserveEntity createNewReservation(String customerName, int customerNumber, LocalDate dateReservation, boolean reservationStatus, String state, MenuEntity menuEntity) {
        try {
            if (customerName == null || customerName.isEmpty()) {
                throw new IllegalArgumentException("The customer name is required.");
            }
            if (dateReservation == null) {
                throw new IllegalArgumentException("The reservation date is required.");
            }
            if (customerNumber <= 0) {
                throw new IllegalArgumentException("The number of people must be greater than zero.");
            }

            ReserveEntity newReservation = new ReserveEntity
                    (customerName,
                     customerNumber,
                     dateReservation,
                     reservationStatus,
                     state,
                     menuEntity);

            if (!reservationStatus) {
                newReservation.cancel();
            } else {
                newReservation.complete();
            }
            ReserveEntity savedReservation = reservaRepository.save(newReservation);
            return savedReservation;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error creating the reservation: " + e.getMessage());
        }
    }


    public List<ReserveEntity> getAllReservation() {
        try {
            return reservaRepository.findAll();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error retrieving all reservations: " + e.getMessage(), e);
        }
    }

    public Object getReservationById(Long id) {
        try {
            Optional<ReserveEntity> result = reservaRepository.findById(id);

            if (result.isPresent()) {
                return result.get();
            } else {
                return "No reservation exists with the specified ID.";
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred while fetching the reservation.", e);
        }
    }

    public ReserveEntity updateById(ReserveEntity request, Long id) {
        try {

            if (request == null) {
                throw new IllegalArgumentException("Request cannot be null.");
            }

            if (request.getCustomerName() == null || request.getCustomerName().isEmpty()) {
                throw new IllegalArgumentException("The customer name is required.");
            }
            if (request.getDateReserve() == null) {
                throw new IllegalArgumentException("The reservation date is required.");
            }
            if (request.getCustomerNumber() <= 0) {
                throw new IllegalArgumentException("The number of people must be greater than zero.");
            }

            ReserveEntity reserve = reservaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Reservation not found with id: " + id));

            reserve.setCustomerName(request.getCustomerName());
            reserve.setCustomerNumber(request.getCustomerNumber());
            reserve.setDateReserve(request.getDateReserve());
            reserve.setReservationStatus(request.getReservationStatus());
            reserve.setState(request.getState());
            reserve.setMenuEntity(request.getMenuEntity());


            if (!request.getReservationStatus()) {
                reserve.cancel();
            } else {
                reserve.complete();
            }


            ReserveEntity savedReservation = reservaRepository.save(reserve);

            return savedReservation;
        } catch (Exception e) {

            throw new IllegalArgumentException("Error updating reservation: " + e.getMessage());
        }
    }



}
