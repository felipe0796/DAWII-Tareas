package com.marketplace.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Provincia;
import com.marketplace.service.ProvinciaService;

@RestController
@RequestMapping("/rest/provincia")
public class ProvinciaController {

	@Autowired
	private ProvinciaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Provincia>> listaProvincia(){
		List<Provincia> lista = service.listaProvincia();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Provincia>> listaProvinciaByIDDep(@PathVariable("id") Integer id){
		return ResponseEntity.ok(service.listarProvinciasByIDDepartamento(id));
	}
	
	//Sesion01InicioApplication
	
}
