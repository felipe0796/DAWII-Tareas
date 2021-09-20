package com.marketplace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marketplace.entity.Categoria;
import com.marketplace.entity.Distrito;
import com.marketplace.entity.SubCategoria;

public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer>{
	
	@Query("select x from SubCategoria x where x.categoria.id_categoria = ?1")
	List<SubCategoria> listarSubCategoriaByIDCategoria(Integer idCategoria);

}
