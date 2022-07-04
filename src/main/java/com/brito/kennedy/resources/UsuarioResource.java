package com.brito.kennedy.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brito.kennedy.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<Usuario> finAll(){
		Usuario u = new Usuario(1L, "teste", "teste@gmail.com", "354-879", "123456");
		
		return ResponseEntity.ok().body(u);
	}
	
}
