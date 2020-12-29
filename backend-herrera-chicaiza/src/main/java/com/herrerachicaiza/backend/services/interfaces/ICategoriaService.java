package com.herrerachicaiza.backend.services.interfaces;

import java.util.List;


import com.herrerachicaiza.backend.models.entities.Categoria;

public interface ICategoriaService {
	
	public Categoria findById(Long id);
	public List<Categoria> findAll();

}
