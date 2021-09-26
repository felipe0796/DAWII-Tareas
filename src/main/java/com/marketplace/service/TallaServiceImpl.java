package com.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Talla;
import com.marketplace.entity.TallaSubcategoria;
import com.marketplace.repository.TallaRepository;

@Service
public class TallaServiceImpl implements TallaService{

	@Autowired
	private TallaRepository repository;	
	
	@Override
	public List<TallaSubcategoria> listaTallabyIDSubcategoria(Integer idSubcategoria) {
		return repository.listarTallabyIDSubcategoria(idSubcategoria);
	}

}
