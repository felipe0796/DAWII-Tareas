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

import com.marketplace.entity.SubCategoria;
import com.marketplace.entity.Talla;
import com.marketplace.entity.TallaSubcategoria;
import com.marketplace.service.TallaService;

@RestController
@RequestMapping("/rest/talla")

@CrossOrigin(origins = "http://localhost:4200/")

public class TallaController {
	
	@Autowired
	private TallaService service;
	
	@GetMapping("/idSubca/{id}")
	@ResponseBody
	public ResponseEntity<List<TallaSubcategoria>> listaTallabyIDSubcategoria(@PathVariable("id") Integer id){
		return ResponseEntity.ok(service.listaTallabyIDSubcategoria(id));
	}
}
