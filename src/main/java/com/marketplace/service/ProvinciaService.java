package com.marketplace.service;

import java.util.List;

import com.marketplace.entity.Distrito;
import com.marketplace.entity.Provincia;

public interface ProvinciaService {
	
	public abstract List<Provincia> listaProvincia();
	
	List<Provincia> listarProvinciasByIDDepartamento(Integer idDepartamento);
	
	public abstract List<Provincia> listaProvinciaAsc();

}
