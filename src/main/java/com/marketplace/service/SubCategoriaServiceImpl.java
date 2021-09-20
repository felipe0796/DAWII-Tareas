package com.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Categoria;
import com.marketplace.entity.SubCategoria;
import com.marketplace.repository.SubCategoriaRepository;

@Service
public class SubCategoriaServiceImpl implements SubCategoriaService{

	@Autowired
	private SubCategoriaRepository repository;
	
	/*
	@Override
	public List<SubCategoria> listaSubCategoria() {
		return repository.findAll();
	}
	*/
	@Override
	public List<SubCategoria> listarSubCategoriaByIDCategoria(Integer idCategoria) {
		return repository.listarSubCategoriaByIDCategoria(idCategoria);
	}



}
