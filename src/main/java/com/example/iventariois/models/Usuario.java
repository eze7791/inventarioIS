package com.example.iventariois.models;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String password;
    private String email;
    private boolean es_agente;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    @OneToOne(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Inventario inventario;
}
