package com.marketplace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
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

	private String foto_1;

	private String foto_2;

	private String foto_3;

	private String foto_4;
	
	@ManyToOne
	@JoinColumn(name = "id_entrega")
	private Entrega entrega;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha_publicacion;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public String getFoto_1() {
		return foto_1;
	}

	public void setFoto_1(String foto_1) {
		this.foto_1 = foto_1;
	}

	public String getFoto_2() {
		return foto_2;
	}

	public void setFoto_2(String foto_2) {
		this.foto_2 = foto_2;
	}

	public String getFoto_3() {
		return foto_3;
	}

	public void setFoto_3(String foto_3) {
		this.foto_3 = foto_3;
	}

	public String getFoto_4() {
		return foto_4;
	}

	public void setFoto_4(String foto_4) {
		this.foto_4 = foto_4;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
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
	
	
}
