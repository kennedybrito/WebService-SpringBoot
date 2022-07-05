package com.brito.kennedy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brito.kennedy.entities.Pedido;
import com.brito.kennedy.repositories.PedidoRepository;

@Service
public class PedidoServices {
	
	@Autowired
	private PedidoRepository repository;
	
	// metodo para pesquisar todos os Pedidos
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	// buscando Pedidoo por ID
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}

}
