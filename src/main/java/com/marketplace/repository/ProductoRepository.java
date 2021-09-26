package com.marketplace.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;

import com.marketplace.entity.Producto;
import com.marketplace.entity.SubCategoria;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query("select max(x.id_producto) from Producto x")
	int retornarCodigo();

}
