package com.example.iventariois.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "materiales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Debe ingresar un valor")
    private String nombre;

    @Min(value = 1, message = "El valor minimo es 1")
    @Max(value = 1000, message = "El valor maximo es 1000")
    private int cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_pedido", nullable = true)
    private Pedido pedido;

    @OneToMany(mappedBy = "material")
    private List<Foto> fotos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_inventario", nullable = false)
    private Inventario inventario;

}
