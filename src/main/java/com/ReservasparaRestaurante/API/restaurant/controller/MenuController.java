package com.ReservasparaRestaurante.API.restaurant.controller;

import com.ReservasparaRestaurante.API.restaurant.entities.DinnerEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.MenuDinnerEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.MenuEntity;
import com.ReservasparaRestaurante.API.restaurant.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/create")
    public ResponseEntity<MenuEntity> createMenu(@Valid @RequestBody MenuEntity menuEntity) {
        List<DinnerEntity> dinners = extractDinners(menuEntity.getMenuDinnerEntities());
        MenuEntity createdMenu = menuService.createNewMenu(
                menuEntity.getName(),
                menuEntity.getPrice(),
                menuEntity.isState(),
                dinners
        );
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    private List<DinnerEntity> extractDinners(List<MenuDinnerEntity> menuDinnerEntities) {
        List<DinnerEntity> dinners = new ArrayList<>();
        for (MenuDinnerEntity menuDinnerEntity : menuDinnerEntities) {
            dinners.add(menuDinnerEntity.getDinner());
        }
        return dinners;
    }

    @GetMapping("/getAll")
    public List<MenuEntity> getMenu() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            MenuEntity menuEntity = menuService.getMenuById(id);
            return new ResponseEntity<>(menuEntity, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Menu with id " + id + " does not exist.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching the menu: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public MenuEntity updateMenuById(@RequestBody MenuEntity request, @PathVariable Long id) {
        return menuService.updateMenu(request, id);
    }
}
