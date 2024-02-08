package com.ReservasparaRestaurante.API.restaurant.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MenuDinner")
@Getter
@Setter
@Data
public class MenuDinnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menu_dinner_id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menuEntity;

    @ManyToOne
    @JoinColumn(name = "dinner_id")
    private DinnerEntity dinnerEntity;

    public void setMenu(MenuEntity savedMenu) {
    }

    public void setDinner(DinnerEntity dinner) {
    }
    public DinnerEntity getDinner() {
        return dinnerEntity;
    }
}
