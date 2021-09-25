package com.marketplace.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UsuarioPrincipal implements UserDetails{

	private String nombre_completo;
	private String correo; 
	private String clave;
	private String usuario;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioPrincipal(String nombre_completo, String correo, String clave, String usuario,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nombre_completo = nombre_completo;
		this.correo = correo;
		this.clave = clave;
		this.usuario = usuario;
		this.authorities = authorities;
	}
	
	
	public static UsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority> authorities = 
				usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
				.collect(Collectors.toList());
		return new UsuarioPrincipal(usuario.getNombre_completo(), usuario.getCorreo(), usuario.getClave(), usuario.getUsuario(), authorities); 
		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return clave;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return correo;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	
	
}
