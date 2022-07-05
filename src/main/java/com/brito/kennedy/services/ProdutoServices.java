package com.brito.kennedy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brito.kennedy.entities.Produto;
import com.brito.kennedy.repositories.ProdutoRepository;

@Service
public class ProdutoServices {
	
	@Autowired
	private ProdutoRepository repository;
	
	// metodo para pesquisar todos os Produtos
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	// buscando Produtoo por ID
	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}

}
