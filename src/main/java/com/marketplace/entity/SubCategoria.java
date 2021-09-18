package com.marketplace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sub_categoria")
public class SubCategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_sub_categoria;  
	private String descripcion; 
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public int getId_sub_categoria() {
		return id_sub_categoria;
	}

	public void setId_sub_categoria(int id_sub_categoria) {
		this.id_sub_categoria = id_sub_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	
}
