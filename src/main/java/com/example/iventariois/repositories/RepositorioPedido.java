package com.example.iventariois.repositories;

import com.example.iventariois.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {
    List<Pedido> findByVisto(Boolean visto);

    long countByvisto(Boolean visto);

}
