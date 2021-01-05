package com.herrerachicaiza.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.herrerachicaiza.backend.models.entities.Registro;


public interface IRegistro extends CrudRepository<Registro, Long> {
	@Query("SELECT re FROM Registro re WHERE re.estado = :estado ORDER BY re.estado")
	public List<Registro> buscarPorEstado(String registro);

}
