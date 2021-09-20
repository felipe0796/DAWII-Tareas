package com.marketplace.service;

import java.util.List;

import com.marketplace.entity.Usuario;

public interface UsuarioService {
	
	public abstract List<Usuario> listarUsuario();
	public abstract Usuario registrarUsuario(Usuario obj);

}
