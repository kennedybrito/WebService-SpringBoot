package com.brito.kennedy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brito.kennedy.entities.Categoria;
import com.brito.kennedy.repositories.CategoriaRepository;

@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepository repository;
	
	// metodo para pesquisar todos as categorias
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	// buscando categoria  por ID
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.get();
	}

}
