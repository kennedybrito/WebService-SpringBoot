package com.brito.kennedy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brito.kennedy.entities.Usuario;
import com.brito.kennedy.repositories.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository repository;
	
	// metodo para pesquisar todos os usuarios
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	// buscando usuario por ID
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}

}
