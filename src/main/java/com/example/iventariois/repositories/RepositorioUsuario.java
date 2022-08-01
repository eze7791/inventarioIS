package com.example.iventariois.repositories;

import com.example.iventariois.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    Usuario findBynombre(String nombre);
}
