package com.ReservasparaRestaurante.API.restaurant.dto.reserve;

import lombok.Data;

import java.util.Date;

@Data
public class CreateReserveDtoToUpdate {
    private String customerName;
    private Integer customerNumber;
    private Date dateReserve;
    private Boolean reservationStatus;
    private String state;
}
