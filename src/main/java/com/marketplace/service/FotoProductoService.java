package com.marketplace.service;

import java.util.List;

import com.marketplace.entity.FotoProducto;


public interface FotoProductoService {
	
	public abstract List<FotoProducto> listaEntrega();
	public abstract FotoProducto insertarFoto(FotoProducto obj);

}
