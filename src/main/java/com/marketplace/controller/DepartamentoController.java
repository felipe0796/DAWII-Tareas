package com.marketplace.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Departamento;
import com.marketplace.service.DepartamentoService;

@RestController
@RequestMapping("/rest/departamento")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Departamento>> listaDepartamento(){
		List<Departamento> lista = service.listaDepartamento();
		return ResponseEntity.ok(lista);
	}
	
	//Sesion01InicioApplication
	
}
