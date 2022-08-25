package com.example.iventariois.services;

import com.example.iventariois.models.Usuario;
import com.example.iventariois.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Transactional
    public List<Usuario> findAll() throws Exception{
        try {
            return (List<Usuario>) repositorioUsuario.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Usuario findById(long id) throws Exception{
        try {
            Optional<Usuario> optionalUsuario = repositorioUsuario.findById(id);
            return optionalUsuario.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Usuario saveUsuario(Usuario Usuario) throws Exception{
        try {
            return repositorioUsuario.save(Usuario);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public boolean deleteUsuario(long id) throws Exception{
        try{
            repositorioUsuario.deleteById(id);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



    @Transactional
    public Usuario findByName(String name) throws Exception{
        try {
            return repositorioUsuario.findBynombre(name);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
