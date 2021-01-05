package com.herrerachicaiza.backend.services.interfaces;

import java.util.List;


import com.herrerachicaiza.backend.models.entities.Registro;
import com.herrerachicaiza.backend.models.entities.Voluntario;


public interface IRegistroService {

	public void save(Registro registro);
	public Registro findById(Long id);
	public void delete(Long id);
	public List<Registro> findAll();
	
	/****Métodos personalizados***/
	public List<Registro> findByEstado(String estado);
	
}
