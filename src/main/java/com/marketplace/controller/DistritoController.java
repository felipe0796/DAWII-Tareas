package com.marketplace.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Distrito;
import com.marketplace.entity.Producto;
import com.marketplace.entity.Provincia;
import com.marketplace.repository.DistritoRepository;
import com.marketplace.repository.ProductoRepository;
import com.marketplace.service.DistritoService;

@RestController
@RequestMapping("/rest/distrito")
public class DistritoController {

	@Autowired
	private DistritoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Distrito>> listaDistrito(){
		List<Distrito> lista = service.listaDistrito();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Distrito>> listarDistritosByIDProv(@PathVariable("id") Integer id){
		return ResponseEntity.ok(service.listarDistritosByIDProvincia(id));
	}
	
	/*
	public List<Distrito> listar(){
		List<Distrito> lista;
		final String JDBC_DRIVER= "org.postgresql.Driver";
		final String DB_URL = "jdbc:postgresql://localhost:8080/lista";
		
		
		try (Connection conexion = DriverManager.getConnection(DB_URL,User, PASS)){
			Class.forName(JDBC_DRIVER);
		}
		
	}
	*/
	//Sesion01InicioApplication
	
}
