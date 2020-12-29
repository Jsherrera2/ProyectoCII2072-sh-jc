package com.herrerachicaiza.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herrerachicaiza.backend.models.entities.Categoria;
import com.herrerachicaiza.backend.services.interfaces.ICategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/{id}")
	public Categoria retrive(@PathVariable(value="id") Long id){
		return service.findById(id);	
	}
	
	@GetMapping("")
	public List<Categoria>list(){
		return service.findAll();	
	}

}
