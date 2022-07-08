package com.example.iventariois.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "materiales")
@Data
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private int cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_pedido", nullable = false)
    private Pedido pedido;

    @OneToMany(mappedBy = "material")
    private List<Foto> fotos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_inventario", nullable = false)
    private Inventario inventario;

}
