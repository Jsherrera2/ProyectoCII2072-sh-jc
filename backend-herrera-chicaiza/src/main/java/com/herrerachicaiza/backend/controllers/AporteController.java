package com.herrerachicaiza.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herrerachicaiza.backend.models.entities.Aporte;
import com.herrerachicaiza.backend.services.interfaces.IAporteService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/aporte")
public class AporteController {
	
	@Autowired
	private IAporteService service;
	
	
	@GetMapping("/{id}")
	public Aporte retrive(@PathVariable(value="id")Long id) {
		return service.findById(id);
	}
	
	@GetMapping("")
	public List<Aporte> list(){
		return service.findAll();
	}
	
	
	@GetMapping("/buscar/disponibilidad/{disponibilidad}")	
	public ResponseEntity<Aporte> listByDisponibilidad(@PathVariable String disponibilidad) {
		Aporte ap = service.findByDisponibilidad(disponibilidad);
		if(ap == null) {
			return new ResponseEntity<Aporte>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<Aporte>(ap,HttpStatus.OK);
	}

}
