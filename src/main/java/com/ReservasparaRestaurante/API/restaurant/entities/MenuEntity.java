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

    // Getter y Setter para menuDinnerEntities
    @Getter
    @OneToMany(mappedBy = "menuEntity")
    private List<MenuDinnerEntity> menuDinnerEntities;

    // Constructor vacío requerido por JPA
    public MenuEntity() {
        this.menuDinnerEntities = new ArrayList<>();
    }

    // Constructor con todos los campos excepto el idMenu
    public MenuEntity(String name, double price, boolean state, List<MenuDinnerEntity> menuDinnerEntities) {
        this.name = name;
        this.price = price;
        this.state = state;
        this.menuDinnerEntities = menuDinnerEntities;
    }

    // Getter y Setter para idMenu
    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }
}
