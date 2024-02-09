package com.ReservasparaRestaurante.API.restaurant.dto.menu;

import lombok.Data;

@Data
public class CreateMenuDto {
    private String name;
    private double price;
    private boolean state;

}
