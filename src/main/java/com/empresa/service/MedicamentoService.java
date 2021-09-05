package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	//CRUD
	public abstract List<Medicamento> listaMedicamento();
	public abstract Medicamento insertaActualizaMedicamento(Medicamento obj);
	public abstract Optional<Medicamento> buscaPorId(int idMed);
	public abstract void eliminaPorId(int idMed);
	
	//CONSULTAS
	//Consulta de Medicamento por Nombre use Like
	public abstract List<Medicamento> listaMedicamentoPorNombre(String nombre);
	//Consulta de Medicamento por Stock
	public abstract List<Medicamento> listaMedicamentoPorStock(int min, int max);
	
}
