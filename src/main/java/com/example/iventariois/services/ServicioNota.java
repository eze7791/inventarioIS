package com.example.iventariois.services;

import com.example.iventariois.models.Nota;
import com.example.iventariois.repositories.RepositorioNota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioNota {
    @Autowired
    private RepositorioNota repositorioNota;

    @Transactional
    public List<Nota> findAll() throws Exception{
        try {
            return (List<Nota>) repositorioNota.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Nota findById(long id) throws Exception{
        try {
            Optional<Nota> optionalNota = repositorioNota.findById(id);
            return optionalNota.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Nota saveNota(Nota Nota) throws Exception{
        try {
            return repositorioNota.save(Nota);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public boolean deleteNota(long id) throws Exception{
        try{
            repositorioNota.deleteById(id);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
