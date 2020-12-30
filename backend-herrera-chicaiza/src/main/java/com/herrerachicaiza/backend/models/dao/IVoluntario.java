package com.herrerachicaiza.backend.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.herrerachicaiza.backend.models.entities.Voluntario;

public interface IVoluntario extends CrudRepository<Voluntario, Long>{
	
	@Query("SELECT vo FROM Voluntario vo WHERE vo.apellido = :apellido")
	public Voluntario buscarPorApellido(String apellido);
	
	@Query("SELECT vo FROM Voluntario vo WHERE vo.cedula = :cedula")
	public Voluntario buscarPorCedula(String cedula);
	
	@Query("SELECT vo FROM Voluntario vo WHERE vo.sexo = :gender ORDER BY vo.apellido")
	public List<Voluntario> buscarPorSexo(String gender);

}
