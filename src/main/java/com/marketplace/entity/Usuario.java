package com.marketplace.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;  
	private String nombre_completo;
	private String dni;
	@Column(unique = true)
	private String correo; 
	private String clave;
	@Column(unique = true)
	private String usuario;
	private String telefono;
	private String telef_alter;
	private String direccion;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"),
	inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<Rol> roles = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "id_distrito")
	private Distrito distrito; 
	
	private String foto;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelef_alter() {
		return telef_alter;
	}
	public void setTelef_alter(String telef_alter) {
		this.telef_alter = telef_alter;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	public Usuario() {
		
	}
	public Usuario(String nombre_completo, String dni, String correo, String clave, String telefono) {
		super();
		this.nombre_completo = nombre_completo;
		this.dni = dni;
		this.correo = correo;
		this.clave = clave;
		this.telefono = telefono;
	}
	
	
	
	
	
}
