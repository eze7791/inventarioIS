package com.example.iventariois.services;

import com.example.iventariois.enums.RolNombre;
import com.example.iventariois.models.Rol;
import com.example.iventariois.repositories.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ServicioRol {

    @Autowired
    RepositorioRol repositorioRol;

    public void save(Rol rol){
       repositorioRol.save(rol);
    }

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return repositorioRol.findByRolNombre(rolNombre);
    }

    public boolean existsByRolNombre(RolNombre rolNombre){
        return repositorioRol.existsByRolNombre(rolNombre);
    }
}
