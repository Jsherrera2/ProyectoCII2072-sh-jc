package com.herrerachicaiza.backend.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.herrerachicaiza.backend.models.entities.Aporte;

public interface IAporte extends CrudRepository<Aporte, Long> {
	
	@Query("SELECT ap FROM Aporte ap WHERE ap.disponibilidad = :disponibilidad")
	public Aporte buscarPorDisponibilidad(String disponibilidad);

}
