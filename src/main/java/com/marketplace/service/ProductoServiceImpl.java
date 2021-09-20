package com.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Producto;
import com.marketplace.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository repository;


	@Override
	public List<Producto> listaProducto() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Producto insertarProducto(Producto obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

}
