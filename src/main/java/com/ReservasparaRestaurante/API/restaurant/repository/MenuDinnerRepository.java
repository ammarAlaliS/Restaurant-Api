package com.ReservasparaRestaurante.API.restaurant.repository;

import com.ReservasparaRestaurante.API.restaurant.entities.MenuDinnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDinnerRepository extends JpaRepository<MenuDinnerEntity, Long> {
}
