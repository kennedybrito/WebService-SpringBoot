package com.brito.kennedy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brito.kennedy.entities.Pedido;
import com.brito.kennedy.services.PedidoServices;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoServices service;

	// serviço que busca todos os pedidos
	@GetMapping
	public ResponseEntity<List<Pedido>> finAll(){
		List<Pedido> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value =  "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
