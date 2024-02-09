package com.ReservasparaRestaurante.API.restaurant.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Reserve")
public class ReserveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserve")
    private Long idReserve;

    @NotBlank(message = "Customer name can not be null")
    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_number")
    @NotNull(message = "Customer number can not be null")
    private Integer customerNumber;
    @Column(name = "date_reserve")
    private Date dateReserve;

    @Column(name = "time_reserve")
    @Temporal(TemporalType.TIME)
    private Date timeReserve;

    @Column(name = "reservation_status")
    private Boolean reservationStatus;

    @Column(name = "state")
    private String state;

    @OneToOne
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")
    private MenuEntity menuEntity;

    public ReserveEntity() {
    }

    public ReserveEntity(String customerName, Integer customerNumber, Date dateReserve,boolean reservationStatus, String state, MenuEntity menuEntity) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.dateReserve = dateReserve;
        this.state = state;
        this.menuEntity = menuEntity;
        this.reservationStatus = reservationStatus;
    }

    public void cancel() {
        this.state = "CANCELED";
    }

    public void complete() {
        this.state = "COMPLETED";
    }
}
