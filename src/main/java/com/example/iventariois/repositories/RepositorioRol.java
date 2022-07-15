package com.example.iventariois.repositories;

import com.example.iventariois.enums.RolNombre;
import com.example.iventariois.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioRol extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
    boolean existsByRolNombre (RolNombre rolNombre);

}
