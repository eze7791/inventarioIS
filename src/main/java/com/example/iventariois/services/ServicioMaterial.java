package com.example.iventariois.services;

import com.example.iventariois.models.Material;
import com.example.iventariois.repositories.RepositorioMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioMaterial {
    @Autowired
    private RepositorioMaterial repositorioMaterial;

    @Transactional
    public List<Material> findAll() throws Exception{
        try {
            return (List<Material>) repositorioMaterial.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Material findById(long id) throws Exception{
        try {
            Optional<Material> optionalMaterial = repositorioMaterial.findById(id);
            return optionalMaterial.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Material saveMaterial(Material material) throws Exception{
        try {
            return repositorioMaterial.save(material);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public boolean deleteMaterial(long id) throws Exception{
        try{
            repositorioMaterial.deleteById(id);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }




}
