package com.herrerachicaiza.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import com.herrerachicaiza.backend.models.entities.Registro;
import com.herrerachicaiza.backend.services.interfaces.IRegistroService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/registro")
public class RegistroController {
	
	@Autowired
	private IRegistroService service;
	
	@GetMapping("/{id}")
	public Registro retrieve(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping("")
	public List<Registro> list() {
		return service.findAll();
	}
	
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Registro create(@RequestBody Registro registro) {		
		service.save(registro);
		return registro;
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Registro update(@RequestBody Registro registro, @PathVariable Long id) {		 			
		service.save(registro);
		return registro;
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/buscar/estado/{estado}")
	public List<Registro> listByCategoria(@PathVariable String estado) {
		return service.findByEstado(estado);
	}
}
