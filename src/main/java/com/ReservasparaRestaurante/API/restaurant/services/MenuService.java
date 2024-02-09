package com.ReservasparaRestaurante.API.restaurant.services;

import com.ReservasparaRestaurante.API.restaurant.dto.menu.CreateMenuDto;
import com.ReservasparaRestaurante.API.restaurant.entities.MenuEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.DinnerEntity;
import com.ReservasparaRestaurante.API.restaurant.repository.MenuDinnerRepository;
import com.ReservasparaRestaurante.API.restaurant.repository.MenuRepository;
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

    public MenuEntity createNewMenu(String name, double price, boolean state, List<DinnerEntity> dinners) {
        try {
            var newMenu = new MenuEntity(name, price, state, null);

            return menuRepository.save(newMenu);
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
    public MenuEntity updateMenu(CreateMenuDto request, Long id) {
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

    public String deleteMenuById(Long id) {
        try {
            Optional<MenuEntity> menuOptional = menuRepository.findById(id);

            if (menuOptional.isEmpty()) {
                return "Menu does not exist";
            }
            menuRepository.deleteById(id);
            return "Menu deleted successfully";
        } catch (Exception e) {
            throw new IllegalStateException("Error deleting menu: " + e.getMessage());
        }
    }

}

