package com.marketplace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_provincia")
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
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;
	@ManyToOne
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;
	@ManyToOne
	@JoinColumn(name = "id_distrito")
	private Distrito distrito;
	@Lob
	private byte[] foto_1;
	@Lob
	private byte[] foto_2;
	@Lob
	private byte[] foto_3;
	@Lob
	private byte[] foto_4;
	@ManyToOne
	@JoinColumn(name = "id_entrega")
	private Entrega entrega;
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
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	public byte[] getFoto_1() {
		return foto_1;
	}
	public void setFoto_1(byte[] foto_1) {
		this.foto_1 = foto_1;
	}
	public byte[] getFoto_2() {
		return foto_2;
	}
	public void setFoto_2(byte[] foto_2) {
		this.foto_2 = foto_2;
	}
	public byte[] getFoto_3() {
		return foto_3;
	}
	public void setFoto_3(byte[] foto_3) {
		this.foto_3 = foto_3;
	}
	public byte[] getFoto_4() {
		return foto_4;
	}
	public void setFoto_4(byte[] foto_4) {
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
