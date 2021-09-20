package com.marketplace.service;

import java.util.List;


import com.marketplace.entity.Producto;

public interface ProductoService {
	
	public abstract List<Producto> listaProducto();
	
	public abstract Producto insertarProducto(Producto obj);
	
}
