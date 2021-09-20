package com.marketplace.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marketplace.entity.Usuario;
import com.marketplace.repository.UsuarioRepository;

@Service
public class UsuarioServicelmpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> listarUsuario() {
		return repository.findAll();
	}

	@Override
	public Usuario registrarUsuario(Usuario obj) {
		return repository.save(obj);
	}

}
