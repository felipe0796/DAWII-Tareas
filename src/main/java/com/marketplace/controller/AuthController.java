package com.marketplace.controller;
import java.util.HashSet;

import java.util.Set;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.entity.Rol;
import com.marketplace.entity.RolNombre;
import com.marketplace.entity.Usuario;
import com.marketplace.security.dto.JwtDto;
import com.marketplace.security.dto.LoginUsuario;
import com.marketplace.security.dto.Mensaje;
import com.marketplace.security.dto.NuevoUsuario;
import com.marketplace.security.jwt.JwtProvider;
import com.marketplace.service.RolService;
import com.marketplace.service.UsuarioService;
import com.marketplace.util.Constantes;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/nuevo")
	@ResponseBody
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return new ResponseEntity(Constantes.MENSAJE_REG_ERROR_DATOS, HttpStatus.BAD_REQUEST);
		/*if(usuarioService.existsByUsuario(nuevoUsuario.getUsuario()))
			return new ResponseEntity(Constantes.MENSAJE_REG_YA_EXISTE_USER, HttpStatus.BAD_REQUEST);*/
		if(usuarioService.existsByCorreo(nuevoUsuario.getCorreo()))
			return new ResponseEntity(Constantes.MENSAJE_REG_YA_EXISTE_EMAIL, HttpStatus.BAD_REQUEST);
		
		Usuario usuario = new Usuario(nuevoUsuario.getNombre_completo(), nuevoUsuario.getDni(), nuevoUsuario.getCorreo(),
										passwordEncoder.encode(nuevoUsuario.getClave()),
										 nuevoUsuario.getTelefono()); 
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		if(nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		usuario.setRoles(roles);
		usuarioService.insertaActualizaUsuario(usuario);
		return new ResponseEntity(Constantes.MENSAJE_REG_EXITOSO,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
		if (bindingResult.hasErrors()) 
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		Authentication authentication = 
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
				
	}

}
