package com.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marketplace.entity.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito, Integer>{

	/*@Query("select distinct x.tb_")
	public abstract List<String> listaDistrito();
	*/
	@Query("select d from Distrito d where d.provincia.id_provincia = ?1")
	List<Distrito> listarDistritosByIDProvincia(Integer idProvincia);
}
