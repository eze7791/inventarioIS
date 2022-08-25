package com.example.iventariois.models;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    @OneToOne(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Inventario inventario;

    @OneToMany(mappedBy = "usuario")
    private List<Nota> notas;
}
