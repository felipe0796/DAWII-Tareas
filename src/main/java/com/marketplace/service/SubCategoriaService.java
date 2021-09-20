package com.marketplace.service;

import java.util.List;
import java.util.Optional;

import com.marketplace.entity.Categoria;
import com.marketplace.entity.SubCategoria;

public interface SubCategoriaService {
	
	//public abstract List<SubCategoria> listaSubCategoria();
	
	public abstract List<SubCategoria> listarSubCategoriaByIDCategoria(Integer idCategoria);

}
