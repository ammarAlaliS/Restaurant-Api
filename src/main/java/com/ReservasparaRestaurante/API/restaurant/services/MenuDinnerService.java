//package com.ReservasparaRestaurante.API.restaurant.services;
//
//import com.ReservasparaRestaurante.API.restaurant.entities.DinnerEntity;
//import com.ReservasparaRestaurante.API.restaurant.entities.MenuDinnerEntity;
//import com.ReservasparaRestaurante.API.restaurant.entities.MenuEntity;
//import com.ReservasparaRestaurante.API.restaurant.repository.MenuDinnerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MenuDinnerService {
//
//    private final MenuDinnerRepository menuDinnerRepository;
//
//    @Autowired
//    public MenuDinnerService(MenuDinnerRepository menuDinnerRepository) {
//        this.menuDinnerRepository = menuDinnerRepository;
//    }
//
//    public void createMenuDinnerAssociation(MenuEntity menuEntity, DinnerEntity dinnerEntity) {
//        MenuDinnerEntity menuDinnerEntity = new MenuDinnerEntity();
//        menuDinnerEntity.setMenuEntity(menuEntity);
//        menuDinnerEntity.setDinnerEntity(dinnerEntity);
//        menuDinnerRepository.save(menuDinnerEntity);
//    }
//}
