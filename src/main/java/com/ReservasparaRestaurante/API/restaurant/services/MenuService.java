package com.ReservasparaRestaurante.API.restaurant.services;

import com.ReservasparaRestaurante.API.restaurant.entities.MenuDinnerEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.MenuEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.DinnerEntity;
import com.ReservasparaRestaurante.API.restaurant.repository.MenuDinnerRepository;
import com.ReservasparaRestaurante.API.restaurant.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuDinnerRepository menuDinnerRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, MenuDinnerRepository menuDinnerRepository) {
        this.menuRepository = menuRepository;
        this.menuDinnerRepository = menuDinnerRepository;
    }


    @Transactional
    public MenuEntity createNewMenu(String name, double price, boolean state, List<DinnerEntity> dinners) {
        try {
            MenuEntity newMenu = new MenuEntity(name, price, state, null); // Passing null for dinnerEntities
            MenuEntity savedMenu = menuRepository.save(newMenu);

            for (DinnerEntity dinner : dinners) {
                MenuDinnerEntity menuDinner = new MenuDinnerEntity();
                menuDinner.setMenuEntity(savedMenu);
                menuDinner.setDinnerEntity(dinner);
                menuDinnerRepository.save();
            }
            return savedMenu;
        } catch (Exception e) {
            throw new IllegalStateException("Error creating the menu", e);
        }
    }

    public List<MenuEntity> getAllMenus() {
        try {
            return menuRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Error retrieving all menus", e);
        }
    }

    public MenuEntity getMenuById(Long id) {
        try {
            return menuRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("No menu exists with the specified ID: " + id));
        } catch (Exception e) {
            throw new IllegalStateException("Error fetching the menu with ID: " + id, e);
        }
    }

    public MenuEntity updateMenu(MenuEntity request, Long id) {
        try {
            MenuEntity existingMenu = menuRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Menu not found with ID: " + id));

            existingMenu.setName(request.getName());
            existingMenu.setPrice(request.getPrice());
            existingMenu.setState(request.isState());

            return menuRepository.save(existingMenu);
        } catch (Exception e) {
            throw new IllegalStateException("Error updating the menu with ID: " + id, e);
        }
    }
}

