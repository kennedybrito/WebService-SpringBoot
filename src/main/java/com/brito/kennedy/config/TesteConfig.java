package com.brito.kennedy.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brito.kennedy.entities.Categoria;
import com.brito.kennedy.entities.Pagamento;
import com.brito.kennedy.entities.Pedido;
import com.brito.kennedy.entities.Produto;
import com.brito.kennedy.entities.Usuario;
import com.brito.kennedy.entities.enums.StatusPedido;
import com.brito.kennedy.repositories.CategoriaRepository;
import com.brito.kennedy.repositories.PedidoRepository;
import com.brito.kennedy.repositories.ProdutoRepository;
import com.brito.kennedy.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2 , cat3));
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		Usuario u1 = new Usuario(null, "teste 1" ,"teste1@gmail.com", "555-555", "123456");
		Usuario u2 = new Usuario(null, "teste 2" ,"teste2@gmail.com", "777-777", "12345678");
		
		Pedido o1 = new Pedido(null, Instant.parse("2022-06-20T19:53:07Z"), StatusPedido.Pago, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2022-06-21T03:42:10Z"), StatusPedido.Aguardando_Pagamento ,u2);
		Pedido o3 = new Pedido(null, Instant.parse("2022-06-22T15:21:22Z"), StatusPedido.Enviado ,u1);
		
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2022-06-20T19:53:07Z"), o1);
		o1.setPagamento(pag1);
		pedidoRepository.save(o1);
	}
	
}
