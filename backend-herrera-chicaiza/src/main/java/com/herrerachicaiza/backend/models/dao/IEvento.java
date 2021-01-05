package com.herrerachicaiza.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.herrerachicaiza.backend.models.entities.Evento;





public interface IEvento extends CrudRepository<Evento, Long>{

	@Query("SELECT ev FROM Evento ev WHERE ev.nombre = :nombre")
	public Evento buscarPorNombre(String nombre);
	
	@Query("SELECT ev FROM Evento ev WHERE ev.categoria = :categoria ORDER BY ev.categoria")
	public List<Evento> buscarPorCategoria(String categoria);
}
