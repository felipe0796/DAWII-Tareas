package com.marketplace.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Distrito;
import com.marketplace.service.DistritoService;

@RestController
@RequestMapping("/rest/distrito")
@CrossOrigin(origins = "http://localhost:4200/")

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
	
	@GetMapping ("/asc")
	@ResponseBody
	public ResponseEntity<List<Distrito>> listaDistritoAsc(){
		List<Distrito> lista = service.listaDistritoAsc();
		return ResponseEntity.ok(lista);
	}
	
	//Sesion01InicioApplication
	
}
