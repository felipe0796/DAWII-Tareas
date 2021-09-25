package com.marketplace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
@Table(name = "tb_producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_producto;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "id_subcategoria")
	private SubCategoria subcategoria;
	
	private String numero_contacto;
	
	private String nombre; 
	
	private String descripcion; 
	private int condicion;
	
	@ManyToOne
	@JoinColumn(name = "id_talla")
	private Talla talla; 
	private double precio; 
	
	@ManyToOne
	@JoinColumn(name = "id_distrito")
	private Distrito distrito;

	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="America/Lima" )
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha_publicacion;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	
	private double precio1; 
	private String descripcion1; 
	private double precio2; 
	private String descripcion2; 
	private double precio3; 
	private String descripcion3; 
	
	
	
	
	
	
	
	
	
	
	
	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	public SubCategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(SubCategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getNumero_contacto() {
		return numero_contacto;
	}

	public void setNumero_contacto(String numero_contacto) {
		this.numero_contacto = numero_contacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCondicion() {
		return condicion;
	}

	public void setCondicion(int condicion) {
		this.condicion = condicion;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}



	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public double getPrecio1() {
		return precio1;
	}

	public void setPrecio1(double precio1) {
		this.precio1 = precio1;
	}

	public String getDescripcion1() {
		return descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public double getPrecio2() {
		return precio2;
	}

	public void setPrecio2(double precio2) {
		this.precio2 = precio2;
	}

	public String getDescripcion2() {
		return descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public double getPrecio3() {
		return precio3;
	}

	public void setPrecio3(double precio3) {
		this.precio3 = precio3;
	}

	public String getDescripcion3() {
		return descripcion3;
	}

	public void setDescripcion3(String descripcion3) {
		this.descripcion3 = descripcion3;
	}
	
	
}
