package com.marketplace.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.Deflater;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.lang.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.marketplace.util.Constantes;
import com.marketplace.entity.FotoProducto;
import com.marketplace.entity.Producto;
import com.marketplace.service.FotoProductoService;
import com.marketplace.service.ProductoService;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/rest/foto")
@CrossOrigin(origins = "http://localhost:4200/")
public class FotoProductoController {

	@Autowired
	private FotoProductoService service;
	@Autowired
	private ProductoService servicePro;
	
	/*
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<FotoProducto>> listaEntrega(){
		List<FotoProducto> lista = service.listaEntrega();
		return ResponseEntity.ok(lista);
	}
*/
	 @PostMapping("/upload")
	 @ResponseBody
	 //@PostMapping(value = "/upload", produces = { MediaType.APPLICATION_JSON_VALUE })
	     public BodyBuilder uplaodImage(@RequestParam("foto1") MultipartFile file,@Nullable @RequestParam(name = "foto2", required = false) MultipartFile file2,
	    		 @Nullable  @RequestParam(name = "foto3", required = false) MultipartFile file3,@Nullable @RequestParam(name = "foto4", required = false) MultipartFile file4) throws IOException {
	
	         System.out.println("Original Image Byte Size - " + file.getBytes().length);
	         
	         FotoProducto foto= new FotoProducto();
	         foto.setFoto1(file.getBytes());
	         if(file2!=null) {
	         foto.setFoto2(file2.getBytes());
	         }
	         else {
	        	 foto.setFoto2(null);
	         }
	         if(file3!=null) {
	        	 foto.setFoto3(file3.getBytes());
		         }
	         else {
	        	 foto.setFoto3(null);
	         }
	         if(file4!=null) {
	        	 foto.setFoto4(file4.getBytes());
		         }
	         else {
	        	 foto.setFoto4(null);
	         }
	        
	         
	         Producto producto= new Producto();
	         int codigo = servicePro.retornarCodigo()+1;
	         producto.setId_producto(codigo);
	         foto.setProducto(producto);
	        
	         service.insertarFoto(foto);
	         
	         return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Expose-Headers", "error") ;
	     }
	


	

	 public static byte[] compressBytes(byte[] data) {
		         Deflater deflater = new Deflater();
		         deflater.setInput(data);
		         deflater.finish();
		         ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		         byte[] buffer = new byte[1024];
		         while (!deflater.finished()) {
		             int count = deflater.deflate(buffer);
		             outputStream.write(buffer, 0, count);
		         }
		         try {    outputStream.close();
		         } catch (IOException e) {
		         }
		         System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		         return outputStream.toByteArray();
	
		     }
	 /*
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registraFoto(@RequestBody FotoProducto obj){
			Map<String, Object> salida = new HashMap<>();
		try {
			FotoProducto objSalida = service.insertarFoto(obj);
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
*/
	
	
	
	
}
