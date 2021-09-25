package com.marketplace.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

	public List<Departamento> findByOrderByDescripcionAsc ();
	
	
}
