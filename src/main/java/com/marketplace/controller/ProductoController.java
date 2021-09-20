package com.marketplace.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.marketplace.entity.Producto;
import com.marketplace.repository.ProductoRepository;
import com.marketplace.service.ProductoService;

@RestController
@RequestMapping("/rest/producto")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProducto(){
		List<Producto> lista = service.listaProducto();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Producto> registrarProducto(@RequestBody Producto obj){
		Producto objSalida =service.insertarProducto(obj);
		if(objSalida == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(objSalida);
	}

	//Sesion01InicioApplication
	
}
