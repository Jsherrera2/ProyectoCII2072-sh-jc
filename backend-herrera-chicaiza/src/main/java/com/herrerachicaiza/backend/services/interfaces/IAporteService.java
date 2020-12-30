package com.herrerachicaiza.backend.services.interfaces;

import java.util.List;

import com.herrerachicaiza.backend.models.entities.Aporte;

public interface IAporteService {
	
	public Aporte findById(Long id);
	public List<Aporte> findAll();
	
	/****Métodos personalizados***/
	
	public Aporte findByDisponibilidad(String disponibilidad);

}
