package com.example.car_rent.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="has_accidents")
    private boolean hasAccidents;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car; // FK към Car

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client; // FK към Client

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted")
    private boolean deleted;
}
