package com.marketplace.service;

import java.util.List;

import com.marketplace.entity.Talla;
import com.marketplace.entity.TallaSubcategoria;

public interface TallaService {
	
	public abstract List<TallaSubcategoria>listaTallabyIDSubcategoria(Integer idSubcategoria);

}
