package com.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Distrito;
import com.marketplace.repository.DistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService{

	@Autowired
	private DistritoRepository repository;
	
	@Override
	public List<Distrito> listaDistrito() {
		return repository.findAll();
	}

}
