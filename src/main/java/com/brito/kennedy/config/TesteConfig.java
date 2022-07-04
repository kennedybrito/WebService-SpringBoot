package com.brito.kennedy.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brito.kennedy.entities.Usuario;
import com.brito.kennedy.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "teste 1" ,"teste1@gmail.com", "555-555", "123456");
		Usuario u2 = new Usuario(null, "teste 2" ,"teste2@gmail.com", "777-777", "12345678");
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
	}
	
}
