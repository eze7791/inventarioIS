package com.example.iventariois.models;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventarios")
@Data
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String agencia;

    @OneToMany(mappedBy = "inventario")
    private List<Material> materiales;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

}
