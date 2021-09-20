package com.marketplace.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import com.marketplace.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
