package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.empresa.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
	
	public List<Medicamento> findByNombreStartsWith (String nombre);
	
	public List<Medicamento> findByStockBetween (int min, int max);
	
}
