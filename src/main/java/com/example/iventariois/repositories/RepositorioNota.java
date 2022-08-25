package com.example.iventariois.repositories;

import com.example.iventariois.models.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioNota extends JpaRepository<Nota, Long> {
}
