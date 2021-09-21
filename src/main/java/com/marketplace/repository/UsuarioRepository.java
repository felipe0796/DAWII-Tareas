package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
