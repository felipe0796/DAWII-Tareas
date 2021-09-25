package com.marketplace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_talla_subcategoria")
public class TallaSubcategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_talla_subcategoria;
	@ManyToOne
	@JoinColumn(name = "id_talla")
	private Talla talla;
	@ManyToOne
	@JoinColumn(name = "id_sub_categoria")
	private SubCategoria subcategoria;
	
	public int getId_talla_subcategoria() {
		return id_talla_subcategoria;
	}
	public void setId_talla_subcategoria(int id_talla_subcategoria) {
		this.id_talla_subcategoria = id_talla_subcategoria;
	}
	public Talla getTalla() {
		return talla;
	}
	public void setTalla(Talla talla) {
		this.talla = talla;
	}
	public SubCategoria getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(SubCategoria subcategoria) {
		this.subcategoria = subcategoria;
	}
	
	

	
}
