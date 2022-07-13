package com.example.iventariois.services;

import com.example.iventariois.models.Inventario;
import com.example.iventariois.repositories.RepositorioInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioInventario {

    @Autowired
    private RepositorioInventario repositorioInventario;

    @Transactional
    public List<Inventario> findAll() throws Exception{
        try {
            return (List<Inventario>) repositorioInventario.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Inventario findById(long id) throws Exception{
        try {
            Optional<Inventario> optionalInventario = repositorioInventario.findById(id);
            return optionalInventario.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Inventario saveInventario(Inventario inventario) throws Exception{
        try {
            return repositorioInventario.save(inventario);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public boolean deleteInventario(long id) throws Exception{
        try{
            repositorioInventario.deleteById(id);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
