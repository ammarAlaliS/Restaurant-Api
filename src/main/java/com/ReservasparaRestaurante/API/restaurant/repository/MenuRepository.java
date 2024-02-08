package com.ReservasparaRestaurante.API.restaurant.repository;

import com.ReservasparaRestaurante.API.restaurant.entities.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
