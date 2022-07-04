package com.brito.kennedy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brito.kennedy.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
