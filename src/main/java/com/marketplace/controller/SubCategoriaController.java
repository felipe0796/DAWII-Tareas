package com.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Distrito;
import com.marketplace.entity.SubCategoria;
import com.marketplace.service.SubCategoriaService;

@RestController
@RequestMapping("/rest/subcategoria")
@CrossOrigin(origins = "http://localhost:4200")
public class SubCategoriaController {
	
	@Autowired
	private SubCategoriaService service;
	
	/*
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<SubCategoria>> listaSubCategoria(){
		List<SubCategoria> lista = service.listaSubCategoria();
		return ResponseEntity.ok(lista);
	}
	*/
	@GetMapping("/idCat/{id}")
	@ResponseBody
	public ResponseEntity<List<SubCategoria>> listarSubCategoriaByIDCat(@PathVariable("id") Integer id){
		return ResponseEntity.ok(service.listarSubCategoriaByIDCategoria(id));
	}

}
