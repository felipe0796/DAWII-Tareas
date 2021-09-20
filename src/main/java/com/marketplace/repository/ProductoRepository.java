package com.marketplace.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import com.marketplace.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{


}
