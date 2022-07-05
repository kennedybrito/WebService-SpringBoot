package com.brito.kennedy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brito.kennedy.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
