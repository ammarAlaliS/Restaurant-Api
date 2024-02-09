package com.ReservasparaRestaurante.API.restaurant.entities;

import com.ReservasparaRestaurante.API.restaurant.entities.MenuDinnerEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Menu")
@Data
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Long idMenu;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "state")
    private boolean state;

    @Getter
    @OneToMany(mappedBy = "menuEntity")
    private List<MenuDinnerEntity> menuDinnerEntities;

    public MenuEntity() {
        this.menuDinnerEntities = new ArrayList<>();
    }


    public MenuEntity(String name, double price, boolean state, List<MenuDinnerEntity> menuDinnerEntities) {
        this.name = name;
        this.price = price;
        this.state = state;
        this.menuDinnerEntities = menuDinnerEntities;
    }

}
