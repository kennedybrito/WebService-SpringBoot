package com.brito.kennedy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brito.kennedy.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
