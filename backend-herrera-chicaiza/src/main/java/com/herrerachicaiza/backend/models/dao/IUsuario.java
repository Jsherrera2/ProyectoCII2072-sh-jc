package com.herrerachicaiza.backend.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.herrerachicaiza.backend.models.entities.Aporte;
import com.herrerachicaiza.backend.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Long>{
	
	@Query("SELECT us FROM Usuario us WHERE us.usuario = :usuario")
	public Usuario buscarPorUsuario(String usuario);
	
	@Query("SELECT us FROM Usuario us WHERE us.rol = :rol")
	public Usuario buscarPorRol(String rol);

}
