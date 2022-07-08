package com.example.iventariois.models;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="No puede ser nulo la fecha")
    @PastOrPresent(message="Debe ser igual o menor a la fecha de hoy")*/
    private Date fecha;

    private String descripcion;
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido")
    private List<Material> materiales;

}
