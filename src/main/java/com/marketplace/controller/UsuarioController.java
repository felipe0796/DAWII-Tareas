package com.marketplace.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marketplace.entity.Distrito;
import com.marketplace.entity.Estado;
import com.marketplace.entity.Usuario;
import com.marketplace.service.UsuarioEntService;
import com.marketplace.service.UsuarioService;
import com.marketplace.util.Constantes;

@RestController
@RequestMapping("/rest/usuario")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioEntService usuarioservice;
	
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
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaUsuario
		(
		 @RequestParam("id_usuario") int id_usuario,
		 @RequestParam("nombre_completo") String nombre_completo,
		 @RequestParam("dni") String dni,
		 @RequestParam("correo") String correo,
		 @RequestParam("clave") String clave,
		 @RequestParam("usuario") String usuario,
		 @RequestParam("telefono") String telefono,
		 @RequestParam("direccion") String direccion,
		 @RequestParam("distrito") int distrito,
		 @RequestParam("foto")  MultipartFile foto
		 )
	{
		Map<String, Object> salida=new HashMap<>();
		try {
			Optional<Usuario> optUsuario = usuarioservice.getById(id_usuario);
			if (optUsuario.isPresent()) {
				Usuario usu = new Usuario();
				usu.setId_usuario(id_usuario);
				usu.setNombre_completo(nombre_completo);
				usu.setDni(dni);
				usu.setCorreo(correo);
				usu.setClave(passwordEncoder.encode(clave));
				usu.setUsuario(usuario);
				usu.setTelefono(telefono);
				usu.setDireccion(direccion);
				Distrito dis = new Distrito();
				dis.setId_distrito(distrito);
				usu.setDistrito(dis);
				usu.setFoto(foto.getBytes());
				Estado est =new Estado();
				est.setId_estado(1);
				usu.setEstado(est);
				Date fecha = new Date();
				usu.setFecha_actualizacion(fecha);
				Usuario objUsuario = usuarioservice.insertaActualizaUsuario(usu);
				if(objUsuario==null) {
					salida.put("mensaje", "errorAct");
				}else {
					salida.put("mensaje", "okAct");
				}
			} else {
				salida.put("mensaje", "errorNoUsu");
			}
				
		} catch (Exception e) {
			//e.printStackTrace();
			salida.put("mensaje", "errorBd");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/id/{id}")
	@ResponseBody
	public ResponseEntity<Usuario> listaUsuarioPorId(@PathVariable("id")int idUsuario){
		Optional<Usuario> optUsuario = usuarioservice.getById(idUsuario);
		if (optUsuario.isPresent()) {
			return ResponseEntity.ok(optUsuario.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

}
