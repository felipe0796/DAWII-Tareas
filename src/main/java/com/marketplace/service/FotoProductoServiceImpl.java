package com.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Categoria;
import com.marketplace.entity.FotoProducto;
import com.marketplace.repository.CategoriaRepository;
import com.marketplace.repository.FotoProductoRepository;


@Service
public class FotoProductoServiceImpl implements FotoProductoService{

	@Autowired
	private FotoProductoRepository repository;
	


	@Override
	public List<FotoProducto> listaEntrega() {
		return repository.findAll();
	}

	@Override
	public FotoProducto insertarFoto(FotoProducto obj) {
		return repository.save(obj);
	}

}
