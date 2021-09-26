package com.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.entity.Departamento;
import com.marketplace.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoRepository repository;
	
	@Override
	public List<Departamento> listaDepartamento() {
		return repository.findAll();
	}

	@Override
	public List<Departamento> listaDepartamentoAsc() {
		return repository.findByOrderByDescripcionAsc();
	}

}
