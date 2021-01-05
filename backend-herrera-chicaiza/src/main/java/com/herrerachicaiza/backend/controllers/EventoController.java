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

import com.herrerachicaiza.backend.models.entities.Evento;
import com.herrerachicaiza.backend.services.interfaces.IEventoService;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/evento")
public class EventoController {
	@Autowired
	private IEventoService service;
	
	@GetMapping("/{id}")
	public Evento retrieve(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping("")
	public List<Evento> list() {
		return service.findAll();
	}
	
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Evento create(@RequestBody Evento evento) {		
		service.save(evento);
		return evento;
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Evento update(@RequestBody Evento evento, @PathVariable Long id) {		 			
		service.save(evento);
		return evento;
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/buscar/nombre/{nombre}")	
	public ResponseEntity<Evento> listByName(@PathVariable String nombre) {
		Evento ev = service.findByNombre(nombre);
		if(ev == null) {
			return new ResponseEntity<Evento>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<Evento>(ev,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/categoria/{categoria}")
	public List<Evento> listByCategoria(@PathVariable String categoria) {
		return service.findByCategoria(categoria);
	}
	
	
	
	
}
