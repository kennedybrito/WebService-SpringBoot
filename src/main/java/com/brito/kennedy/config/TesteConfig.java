package com.brito.kennedy.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brito.kennedy.entities.Pedido;
import com.brito.kennedy.entities.Usuario;
import com.brito.kennedy.repositories.PedidoRepository;
import com.brito.kennedy.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "teste 1" ,"teste1@gmail.com", "555-555", "123456");
		Usuario u2 = new Usuario(null, "teste 2" ,"teste2@gmail.com", "777-777", "12345678");
		
		Pedido o1 = new Pedido(null, Instant.parse("2022-06-20T19:53:07Z"), u1);
		Pedido o2 = new Pedido(null, Instant.parse("2022-06-21T03:42:10Z"), u2);
		Pedido o3 = new Pedido(null, Instant.parse("2022-06-22T15:21:22Z"), u1);
		
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
