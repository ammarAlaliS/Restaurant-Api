package com.ReservasparaRestaurante.API.restaurant.services;

import com.ReservasparaRestaurante.API.restaurant.entities.DinnerEntity;
import com.ReservasparaRestaurante.API.restaurant.repository.DinnerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class DinnerService {

    private final DinnerRepository dinnerRepository;

    public DinnerService(DinnerRepository dinnerRepository) {
        this.dinnerRepository = dinnerRepository;
    }

    public DinnerEntity createNewDinner(int idDinner, String name, String description, BigDecimal price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be a positive value");
        }

        DinnerEntity dinnerEntity = new DinnerEntity();
        dinnerEntity.setIdDinner(idDinner);
        dinnerEntity.setName(name);
        dinnerEntity.setDescription(description);
        dinnerEntity.setPrice(price);

        try {
            return dinnerRepository.save(dinnerEntity);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error creating the dinner: " + e.getMessage());
        }
    }

    public List<DinnerEntity> getAllDinners() {
        try {
            return dinnerRepository.findAll();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error retrieving all menu:" + e);
        }
    }

    public Object getDinnerById(Long id) {
        try {
            Optional<DinnerEntity> result = dinnerRepository.findById(id);

            if (result.isPresent()) {
                return result.get();
            } else {
                return "No dinner exists with the specified ID.";
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("No dinner exists with the specified ID. " + e.getMessage());
        }
    }

    public DinnerEntity updateMenuById(DinnerEntity request, Long id) {
        try {
            DinnerEntity dinner = dinnerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Reservation not found with id: " + id));
            dinner.setName(request.getName());
            dinner.setDescription(request.getDescription());
            dinner.setPrice(request.getPrice());
            dinner.setIdDinner(request.getIdDinner());
            return dinnerRepository.save(dinner);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating dinner: " + e.getMessage());
        }
    }
}
