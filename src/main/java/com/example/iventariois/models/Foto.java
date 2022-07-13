package com.example.iventariois.models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "fotos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imagen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_material", nullable = false)
    private Material material;
}
