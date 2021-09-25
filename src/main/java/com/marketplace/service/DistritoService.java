package com.marketplace.service;

import java.util.List;

import com.marketplace.entity.Distrito;

public interface DistritoService {
	
	public abstract List<Distrito> listaDistrito();
	
	List<Distrito> listarDistritosByIDProvincia(Integer idProvincia);
	
	public abstract List<Distrito> listaDistritoAsc();

}
