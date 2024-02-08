package com.ReservasparaRestaurante.API.restaurant.repository;

import com.ReservasparaRestaurante.API.restaurant.entities.ReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReserveEntity, Long> {


}
