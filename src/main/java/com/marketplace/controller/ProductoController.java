package com.marketplace.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.zip.Deflater;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.util.Constantes;
import com.marketplace.entity.FotoProducto;
import com.marketplace.entity.Estado;
import com.marketplace.entity.Producto;
import com.marketplace.entity.Usuario;
import com.marketplace.repository.ProductoRepository;
import com.marketplace.service.FotoProductoService;
import com.marketplace.service.ProductoService;

@RestController
@RequestMapping("/rest/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	private ProductoService service;
	@Autowired
	private FotoProductoService entregaservice;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProducto(){
		List<Producto> lista = service.listaProducto();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/codigo")
	@ResponseBody
	public Integer retornarCodigo(){
		int codigo = service.retornarCodigo()+1;
		return codigo;
	}
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registrarProducto(@RequestBody Producto obj) throws ParseException{
			Map<String, Object> salida = new HashMap<>();
			Date dateobj = new Date();
			SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
			Date fec=fecha.parse(dateobj.toInstant().toString());
			obj.setFecha_publicacion(fec);
			
			Estado estado= new Estado();
			estado.setId_estado(1);
			obj.setEstado(estado);
			
			Usuario usuario= new Usuario();
			usuario.setId_usuario(1);
			obj.setUsuario(usuario);
			
			
			//String head = "data:image/jpeg;base64,";
			//String base64 = obj.getFoto_1().substring(head.length()-1);
			//byte[] foto_1=DatatypeConverter.parseBase64Binary(base64);
			//obj.setFoto_1(foto_1);
			
		try {
			
			Producto objSalida = service.insertarProducto(obj);
			if (objSalida == null) {
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
