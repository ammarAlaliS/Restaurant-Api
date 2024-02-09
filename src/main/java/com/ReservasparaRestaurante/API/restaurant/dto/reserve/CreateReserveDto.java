package com.ReservasparaRestaurante.API.restaurant.dto.reserve;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CreateReserveDto {
    private String customerName;
    private Integer customerNumber;
    private Date dateReserve;

}
