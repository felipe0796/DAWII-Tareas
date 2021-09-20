package com.marketplace.service;

import java.util.List;
import java.util.Optional;

import com.marketplace.entity.Producto;

public interface ProductoService {
	
	public abstract List<Producto> listaProducto();
	
	public abstract Producto insertarProducto(Producto obj);
	
	public abstract Optional<Producto> buscarProductoPorId(int idProd);
	
	public abstract void eliminarProducto (int idProd);
}
