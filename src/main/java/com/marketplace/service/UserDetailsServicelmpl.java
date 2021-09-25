package com.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Usuario;
import com.marketplace.entity.UsuarioPrincipal;

@Service
public class UserDetailsServicelmpl implements UserDetailsService{

	@Autowired
	UsuarioService usuarioService;
	
	
	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByCorreo(correo).get();
		return UsuarioPrincipal.build(usuario);
	}
	


}
