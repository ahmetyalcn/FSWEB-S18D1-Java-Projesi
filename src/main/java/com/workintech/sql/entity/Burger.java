package com.workintech.sql.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "burger", schema = "public")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;


    @Column(name = "price")
    @DecimalMin("20")
    private double price;

    @Column(name = "is_vegan")
    private boolean isVegan;

    @Enumerated(value = EnumType.STRING)
    private BreadType breadType;

    @Column(name = "contents")
    private List<String> contents;
}
