package com.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marketplace.entity.Usuario;
import com.marketplace.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	
	public List<Usuario> listarUsuario() {
		return repository.findAll();
	}

	
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repository.save(obj);
	}
	
	//Security
	
	public Optional<Usuario>getByUsuario(String usuario){
		return repository.findByUsuario(usuario);
	}
	
	public Optional<Usuario>getByCorreo(String correo){
		return repository.findByCorreo(correo);
	}

	
	public boolean existsByUsuario(String usuario) {
		return repository.existsByUsuario(usuario);
	}

	
	public boolean existsByCorreo(String correo) {
		return repository.existsByCorreo(correo);
	}
}
