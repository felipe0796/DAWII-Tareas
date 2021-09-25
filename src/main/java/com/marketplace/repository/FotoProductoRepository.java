package com.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marketplace.entity.FotoProducto;
import com.marketplace.entity.SubCategoria;

public interface FotoProductoRepository extends JpaRepository<FotoProducto, Integer>{


}
