package com.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Talla;
import com.marketplace.service.TallaService;

@RestController
@RequestMapping("/rest/talla")
public class TallaController {
	
	@Autowired
	private TallaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Talla>> listaTalla(){
		List<Talla> lista = service.listaTalla();
		return ResponseEntity.ok(lista);
	}

}
