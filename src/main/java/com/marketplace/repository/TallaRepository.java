package com.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marketplace.entity.Talla;
import com.marketplace.entity.TallaSubcategoria;

public interface TallaRepository extends JpaRepository<TallaSubcategoria, Integer>{
	@Query("select x from TallaSubcategoria x where x.subcategoria.id_sub_categoria = ?1")
	List<TallaSubcategoria> listarTallabyIDSubcategoria(Integer idSubcategoria);
}
