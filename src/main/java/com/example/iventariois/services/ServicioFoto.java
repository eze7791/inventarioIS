package com.example.iventariois.services;

import com.example.iventariois.models.Foto;
import com.example.iventariois.repositories.RepositorioFoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioFoto {

    @Autowired
    private RepositorioFoto repositorioFoto;

    @Transactional
    public List<Foto> findAll() throws Exception{
        try {
            return (List<Foto>) repositorioFoto.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Foto findById(long id) throws Exception{
        try {
            Optional<Foto> optionalFoto = repositorioFoto.findById(id);
            return optionalFoto.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Foto saveFoto(Foto foto) throws Exception{
        try {
            return repositorioFoto.save(foto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public boolean deleteFoto(long id) throws Exception{
        try{
            repositorioFoto.deleteById(id);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
