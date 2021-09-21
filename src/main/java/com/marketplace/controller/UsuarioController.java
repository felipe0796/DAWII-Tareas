package com.marketplace.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.marketplace.util.Constantes;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioservice;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listarUsuario(){
		List<Usuario> lista= usuarioservice.listarUsuario();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarUsuario(@RequestBody Usuario obj){
		Map<String, Object> salida=new HashMap<>();
		try {
			Usuario objUsuario = usuarioservice.insertaActualizaUsuario(obj);
			if(objUsuario==null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	

}
