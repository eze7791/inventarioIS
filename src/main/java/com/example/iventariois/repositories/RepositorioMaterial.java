package com.example.iventariois.repositories;

import com.example.iventariois.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMaterial extends JpaRepository<Material, Long> {

}
