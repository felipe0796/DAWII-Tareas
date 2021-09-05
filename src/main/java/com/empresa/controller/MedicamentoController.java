package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listaMedicamento(){
		List<Medicamento> lista = service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> insertaMedicamento(@RequestBody Medicamento obj){
		if (obj == null) {
			return ResponseEntity.noContent().build();	
		}else {
			obj.setIdMedicamento(0);
			Medicamento objSalida = service.insertaActualizaMedicamento(obj);
			return ResponseEntity.ok(objSalida);
		}
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Medicamento> actualizaMedicamento(@RequestBody Medicamento obj){
		if (obj == null) {
			return ResponseEntity.badRequest().build();
		} else {
			Optional<Medicamento> optMedicamento = service.buscaPorId(obj.getIdMedicamento());
			if (optMedicamento.isPresent()) {
				Medicamento objAct = service.insertaActualizaMedicamento(obj);
				return ResponseEntity.ok(objAct);
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Medicamento> eliminaMedicamento(@PathVariable("id") int idMed){
		Optional<Medicamento> optMed = service.buscaPorId(idMed);
		if (optMed.isPresent()) {
			service.eliminaPorId(idMed);
			Optional<Medicamento> objElm = service.buscaPorId(idMed);
			if (objElm.isPresent()) {
				return ResponseEntity.badRequest().build();
			} else {
				return ResponseEntity.ok(optMed.get());
			}
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/id/{id}")
	@ResponseBody
	public ResponseEntity<Medicamento> listaMedicamentoPorId(@PathVariable("id")int idMed){
		Optional<Medicamento> optMed = service.buscaPorId(idMed);
		if (optMed.isPresent()) {
			return ResponseEntity.ok(optMed.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/nombre/{nom}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listaMedicamentoPorNombre(@PathVariable("nom")String nombre){
		List<Medicamento> lista =service.listaMedicamentoPorNombre(nombre);
		if (CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);		
		}
	}
	
	@GetMapping("/stock/{min}/{max}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listaMedicamentoPorStock(@PathVariable("min")int min, @PathVariable("max")int max){
		List<Medicamento> lista =service.listaMedicamentoPorStock(min, max);
		if (CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);		
		}
	}
	

}
