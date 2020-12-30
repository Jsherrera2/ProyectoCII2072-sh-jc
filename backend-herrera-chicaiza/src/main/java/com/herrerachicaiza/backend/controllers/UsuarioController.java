package com.herrerachicaiza.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herrerachicaiza.backend.models.entities.Aporte;
import com.herrerachicaiza.backend.models.entities.Usuario;
import com.herrerachicaiza.backend.services.interfaces.IUsuarioService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/{id}")
	public Usuario retrive(@PathVariable(value="id")Long id) {
		return service.findById(id);
	}
	
	@GetMapping("/buscar/usuario/{usuario}")	
	public ResponseEntity<Usuario> listByUsuario(@PathVariable String usuario) {
		Usuario us = service.findByUsuario(usuario);
		if(us == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<Usuario>(us,HttpStatus.OK);
	}
	
	
	@GetMapping("/buscar/rol/{rol}")	
	public ResponseEntity<Usuario> listByRol(@PathVariable String rol) {
		Usuario us = service.findByRol(rol);
		if(us == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		
			return new ResponseEntity<Usuario>(us,HttpStatus.OK);
	}

}
