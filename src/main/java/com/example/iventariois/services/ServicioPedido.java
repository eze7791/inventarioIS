package com.example.iventariois.services;


import com.example.iventariois.models.Pedido;
import com.example.iventariois.repositories.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioPedido {
    @Autowired
    private RepositorioPedido repositorioPedido ;

    @Transactional
    public List<Pedido> findAll() throws Exception{
        try {
            return (List<Pedido>) repositorioPedido.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Pedido findById(long id) throws Exception{
        try {
            Optional<Pedido> optionalPedido = repositorioPedido.findById(id);
            return optionalPedido.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Pedido savePedido(Pedido pedido) throws Exception{
        try {
            return repositorioPedido.save(pedido);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public boolean deletePedido(long id) throws Exception{
        try{
            repositorioPedido.deleteById(id);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
