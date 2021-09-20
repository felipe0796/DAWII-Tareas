package com.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Categoria;
import com.marketplace.repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public List<Categoria> listaCategoria() {
		return repository.findAll();
	}

}
