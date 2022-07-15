package com.example.iventariois.models;

import com.example.iventariois.enums.RolNombre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RolNombre rolNombre;
}
