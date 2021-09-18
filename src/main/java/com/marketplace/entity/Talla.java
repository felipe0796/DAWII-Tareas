package com.marketplace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_talla")
public class Talla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_talla;
	private String descripcion;
	private String tipo;
	
	public int getId_talla() {
		return id_talla;
	}
	public void setId_talla(int id_talla) {
		this.id_talla = id_talla;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
