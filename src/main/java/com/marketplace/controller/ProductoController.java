package com.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProducto(){
		List<Producto> lista = service.listaProducto();
		return ResponseEntity.ok(lista);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	@ResponseBody
	public ResponseEntity<Producto> registrarProducto(@RequestBody Producto obj){
		Producto objSalida =service.insertarProducto(obj);
		if(objSalida == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(objSalida);
	}

	
	
	@GetMapping("/id/{idProd}")
	@ResponseBody
	public ResponseEntity<Producto> listarProductoPorID(@PathVariable("idProd") int idProducto){
		
		Optional<Producto> optProd = service.buscarProductoPorId(idProducto);
		
		if(optProd.isPresent()) {
		return ResponseEntity.ok(optProd.get());	
			
		} else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Producto> editarProducto(@RequestBody Producto obj){
		
		if(obj == null) {
			return ResponseEntity.badRequest().build();
		} else {
		Optional<Producto> optProducto = service.buscarProductoPorId(obj.getId_producto());			
		
				if(optProducto.isPresent()) {
					Producto objModificado = service.insertarProducto(obj);
					return ResponseEntity.ok(objModificado);
				} else {
					return ResponseEntity.badRequest().build();
				}
			
			}
		
		}
	
	@DeleteMapping("/{idProd}")
	@ResponseBody
	public ResponseEntity<Producto> eliminaAlumno(@PathVariable("idProd") int idProducto){
		
		Optional<Producto> optPro = service.buscarProductoPorId(idProducto);
		
			if(optPro.isPresent()) {
				
					service.eliminarProducto(idProducto);
					Optional<Producto> optEliminado = service.buscarProductoPorId(idProducto);
					
					if(optEliminado.isPresent()) {
						
						return ResponseEntity.badRequest().build();
					} else {
						return ResponseEntity.ok(optPro.get());
					}
					
				} else {
				return ResponseEntity.badRequest().build();
			}
	   }	
	
	
	
}
