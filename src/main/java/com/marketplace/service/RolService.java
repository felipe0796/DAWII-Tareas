package com.marketplace.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marketplace.entity.Rol;
import com.marketplace.entity.RolNombre;
import com.marketplace.repository.RolRepository;

@Service
@Transactional
public class RolService {
		
	@Autowired
	private RolRepository repository;
	
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return repository.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol) {
		repository.save(rol);
	}

}
