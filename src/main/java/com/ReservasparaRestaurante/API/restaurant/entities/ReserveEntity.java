package com.ReservasparaRestaurante.API.restaurant.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Reserve")
public class ReserveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserve")
    private Long idReserve;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_number")
    private Integer customerNumber;

    @Column(name = "date_reserve")
    private LocalDate dateReserve;

    @Column(name = "reservation_status")
    private Boolean reservationStatus = false;

    @Column(name = "state")
    private String state;

    @OneToOne
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")
    private MenuEntity menuEntity;

    public ReserveEntity() {
    }

    public ReserveEntity(String customerName, Integer customerNumber, LocalDate dateReserve,boolean reservationStatus, String state, MenuEntity menuEntity) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.dateReserve = dateReserve;
        this.state = state;
        this.menuEntity = menuEntity;
        this.reservationStatus = reservationStatus;
    }

    public void edit() {
        this.state = "EDITED";
    }

    public void cancel() {
        this.state = "CANCELED";
    }

    public void complete() {
        this.state = "COMPLETED";
    }
}
