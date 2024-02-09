package com.ReservasparaRestaurante.API.restaurant.controllers;

import com.ReservasparaRestaurante.API.restaurant.dto.menu.CreateMenuDto;
import com.ReservasparaRestaurante.API.restaurant.entities.DinnerEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.MenuDinnerEntity;
import com.ReservasparaRestaurante.API.restaurant.entities.MenuEntity;
import com.ReservasparaRestaurante.API.restaurant.services.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MenuEntity> createMenu(@RequestBody CreateMenuDto request) {
        MenuEntity newMenu = menuService.createNewMenu(
            request.getName(),
            request.getPrice(),
                true,
                null
        );
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
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
    public MenuEntity updateMenuById(@RequestBody CreateMenuDto request, @PathVariable Long id) {
        return menuService.updateMenu(request, id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable("id") Long id){
        try {
            String menuDeleted = menuService.deleteMenuById(id);
            return ResponseEntity.ok(menuDeleted);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
