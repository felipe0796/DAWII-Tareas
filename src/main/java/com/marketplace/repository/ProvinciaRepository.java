package com.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marketplace.entity.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>{

	@Query("select p from Provincia p where p.departamento.id_departamento = ?1")
	List<Provincia> listarProvinciasByIDDepartamento(Integer idDepartamento);
	
	public List<Provincia> findByOrderByDescripcionAsc ();
}
