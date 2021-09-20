package com.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Usuario;
import com.marketplace.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listarUsuario(){
		List<Usuario> lista= service.listarUsuario();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario obj){
		Usuario objUsuario = service.registrarUsuario(obj);
		if(objUsuario == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(objUsuario);
	}
	

}
