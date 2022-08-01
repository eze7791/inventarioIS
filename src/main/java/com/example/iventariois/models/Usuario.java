package com.example.iventariois.models;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String password;
    private String rol;


    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    @OneToOne(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Inventario inventario;
}
