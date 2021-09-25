package com.marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsuario(String usuario);
	Optional<Usuario> findByCorreo(String correo);
	boolean existsByUsuario(String usuario);
	boolean existsByCorreo(String correo);

}
