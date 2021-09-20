package com.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Distrito;
import com.marketplace.entity.Provincia;
import com.marketplace.repository.ProvinciaRepository;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{

	@Autowired
	private ProvinciaRepository repository;
	
	@Override
	public List<Provincia> listaProvincia() {
		return repository.findAll();
	}

	@Override
	public List<Provincia> listarProvinciasByIDDepartamento(Integer idDepartamento) {
		return repository.listarProvinciasByIDDepartamento(idDepartamento);
	}

}
