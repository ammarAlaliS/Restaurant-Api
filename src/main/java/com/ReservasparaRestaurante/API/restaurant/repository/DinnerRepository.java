package com.ReservasparaRestaurante.API.restaurant.repository;

import com.ReservasparaRestaurante.API.restaurant.entities.DinnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinnerRepository extends JpaRepository<DinnerEntity, Long> {

}
