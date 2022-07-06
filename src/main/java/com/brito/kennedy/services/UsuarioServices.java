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

	public Usuario insert (Usuario obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		
	}
}
