package com.marketplace.service;

import java.util.List;
import java.util.Optional;
import com.marketplace.entity.Usuario;

public interface UsuarioService {
	
	public abstract List<Usuario> listarUsuario();
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
	public abstract Optional<Usuario> getById(int idUsuario);
}
