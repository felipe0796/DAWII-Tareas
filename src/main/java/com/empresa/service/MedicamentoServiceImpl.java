package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{
	
	@Autowired
	private MedicamentoRepository rep;
	
	//CRUD
	@Override
	public List<Medicamento> listaMedicamento() {
		return rep.findAll();
	}

	@Override
	public Medicamento insertaActualizaMedicamento(Medicamento obj) {
		return rep.save(obj);
	}

	@Override
	public Optional<Medicamento> buscaPorId(int idMed) {
		return rep.findById(idMed);
	}

	@Override
	public void eliminaPorId(int idMed) {
		rep.deleteById(idMed);		
	}

	//CONSULTAS
	//Consulta de Medicamento por Nombre use LIke
	@Override
	public List<Medicamento> listaMedicamentoPorNombre(String nombre) {
		return rep.findByNombreStartsWith(nombre);
	}

	@Override
	public List<Medicamento> listaMedicamentoPorStock(int min, int max) {
		return rep.findByStockBetween(min, max);
	}

}
