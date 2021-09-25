package com.marketplace.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDto {
	
	private String token;
	private String bearer = "Bearer";
	private String correo;
	private Collection<? extends GrantedAuthority> authorities;
	
	

	

	public JwtDto(String token, String correo, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.token = token;
		this.correo = correo;
		this.authorities = authorities;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}


	

}
