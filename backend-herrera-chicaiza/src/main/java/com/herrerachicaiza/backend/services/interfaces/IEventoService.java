package com.herrerachicaiza.backend.services.interfaces;

import java.util.List;

import com.herrerachicaiza.backend.models.entities.Evento;
import com.herrerachicaiza.backend.models.entities.Voluntario;


public interface IEventoService {
	public void save(Evento evento);
	public Evento findById(Long id);
	public void delete(Long id);
	public List<Evento> findAll();
	/****Métodos personalizados***/
	public Evento findByNombre(String nombre);
	public List<Evento> findByCategoria(String categoria);
}
