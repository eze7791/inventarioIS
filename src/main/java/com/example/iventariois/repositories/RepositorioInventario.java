package com.example.iventariois.repositories;

import com.example.iventariois.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioInventario extends JpaRepository<Inventario, Long> {

}
