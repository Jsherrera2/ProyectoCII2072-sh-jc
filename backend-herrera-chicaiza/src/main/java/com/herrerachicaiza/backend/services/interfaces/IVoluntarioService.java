package com.herrerachicaiza.backend.services.interfaces;

import java.util.List;

import com.herrerachicaiza.backend.models.entities.Voluntario;

public interface IVoluntarioService {
	
	public void save(Voluntario voluntario);
	public Voluntario findById(Long id);
	public void delete(Long id);
	public List<Voluntario> findAll();
	
	
	/****Métodos personalizados***/
	public List<Voluntario> findBySexo(String gender);
	public Voluntario findByApellido(String apellido);
	public Voluntario findByCedula(String cedula);

}
