package com.ReservasparaRestaurante.API.restaurant.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "Dinner")
@Data
@Getter
@Setter
public class DinnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dinner")
    private int idDinner;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "dinnerEntity")
    private List<MenuDinnerEntity> menuDinnerEntities;
}