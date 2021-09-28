package com.marketplace.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.marketplace.entity.Usuario;

public class JwtDto {
	
	private String token;
	private String bearer = "Bearer";
	private String email;
	private Usuario usuario;

	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtDto(String token, String email, Collection<? extends GrantedAuthority> authorities, Usuario usuario) {
		super();
		this.token = token;
		this.email = email;
		this.authorities = authorities;
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
