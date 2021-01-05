package com.herrerachicaiza.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.herrerachicaiza.backend.models.entities.Voluntario;
import com.herrerachicaiza.backend.services.interfaces.IVoluntarioService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
	
	@Autowired
	private IVoluntarioService service;
	
	@GetMapping("/{id}")
	public Voluntario retrieve(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping("")
	public List<Voluntario> list() {
		return service.findAll();
	}
	
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Voluntario create(@RequestBody Voluntario voluntario) {		
		service.save(voluntario);
		return voluntario;
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Voluntario update(@RequestBody Voluntario voluntario, @PathVariable Long id) {		 			
		service.save(voluntario);
		return voluntario;
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/buscar/sexo/{sexo}")
	public List<Voluntario> listBySexo(@PathVariable String sexo) {
		return service.findBySexo(sexo);
	}
	
	@GetMapping("/buscar/apellido/{apellido}")	
	public ResponseEntity<Voluntario> listByLastName(@PathVariable String apellido) {
		Voluntario vo = service.findByApellido(apellido);
		if(vo == null) {
			return new ResponseEntity<Voluntario>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<Voluntario>(vo,HttpStatus.OK);
	}
	
}
