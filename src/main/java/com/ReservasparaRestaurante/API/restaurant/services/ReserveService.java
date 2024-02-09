package com.ReservasparaRestaurante.API.restaurant.services;

import com.ReservasparaRestaurante.API.restaurant.dto.reserve.CreateReserveDtoToUpdate;
import com.ReservasparaRestaurante.API.restaurant.entities.MenuEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.ReserveEntity;
import com.ReservasparaRestaurante.API.restaurant.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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

    public ReserveEntity createNewReservation(String customerName, int customerNumber, Date dateReservation, boolean reservationStatus, String state, MenuEntity menuEntity) {
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

            var newReservation = new ReserveEntity
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
            return reservaRepository.save(newReservation);
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
            }
                return "No reservation exists with the specified ID.";
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred while fetching the reservation.", e);
        }
    }

    public ReserveEntity updateById(CreateReserveDtoToUpdate request, Long id) {
        try {
            if (request == null) {
                throw new IllegalArgumentException("Request cannot be null.");
            }
            ReserveEntity reserve = reservaRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Reservation not found with id: " + id));

            reserve.setCustomerName(request.getCustomerName());
            reserve.setCustomerNumber(request.getCustomerNumber());
            reserve.setDateReserve(request.getDateReserve());
            reserve.setReservationStatus(request.getReservationStatus());
            reserve.setState(request.getState());


            if (!request.getReservationStatus()) {
                reserve.cancel();
            } else {
                reserve.complete();
            }


            return reservaRepository.save(reserve);
        } catch (Exception e) {

            throw new IllegalArgumentException("Error updating reservation: " + e.getMessage());
        }
    }

    public String deleteReservationById(Long id) {
        try {
            Optional<ReserveEntity> reservationOptional = reservaRepository.findById(id);

            if (reservationOptional.isEmpty()) {
                return "Reservation does not exist";
            }

            reservaRepository.deleteById(id);
            return "Reservation deleted successfully";
        } catch (Exception e) {
            return "Error deleting reservation: " + e.getMessage();
        }
    }
}
