package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.entity.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	
}
