package com.example.iventariois.repositories;

import com.example.iventariois.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {
}
