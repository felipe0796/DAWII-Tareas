package com.marketplace.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Categoria;
import com.marketplace.entity.Distrito;
import com.marketplace.service.CategoriaService;
import com.marketplace.service.DistritoService;

@RestController
@RequestMapping("/rest/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Categoria>> listaCategoria(){
		List<Categoria> lista = service.listaCategoria();
		return ResponseEntity.ok(lista);
	}
	
	//Sesion01InicioApplication
	
}
