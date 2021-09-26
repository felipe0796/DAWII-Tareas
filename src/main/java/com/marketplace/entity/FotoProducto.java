package com.marketplace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javassist.bytecode.ByteArray;

@Entity
@Table(name = "tb_foto_producto")
public class FotoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_foto;
	
	@Lob
	private byte[] foto1;
	@Lob
	private byte[] foto2;
	@Lob
	private byte[] foto3;
	@Lob
	private byte[] foto4;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	

	public int getId_foto() {
		return id_foto;
	}

	public void setId_foto(int id_foto) {
		this.id_foto = id_foto;
	}

	public byte[] getFoto1() {
		return foto1;
	}

	public void setFoto1(byte[] foto1) {
		this.foto1 = foto1;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public byte[] getFoto2() {
		return foto2;
	}

	public void setFoto2(byte[] foto2) {
		this.foto2 = foto2;
	}

	public byte[] getFoto3() {
		return foto3;
	}

	public void setFoto3(byte[] foto3) {
		this.foto3 = foto3;
	}

	public byte[] getFoto4() {
		return foto4;
	}

	public void setFoto4(byte[] foto4) {
		this.foto4 = foto4;
	}
	
	
	
	
}
