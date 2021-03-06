package com.brito.kennedy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brito.kennedy.entities.Categoria;
import com.brito.kennedy.services.CategoriaServices;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaServices service;

	// serviço que busca todos as categorias
	@GetMapping
	public ResponseEntity<List<Categoria>> finAll(){
		List<Categoria> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value =  "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
