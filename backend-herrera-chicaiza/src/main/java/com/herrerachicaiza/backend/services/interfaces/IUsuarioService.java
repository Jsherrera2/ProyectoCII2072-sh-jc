package com.herrerachicaiza.backend.services.interfaces;

import com.herrerachicaiza.backend.models.entities.Usuario;

public interface IUsuarioService {
	
	public Usuario findById(Long id);
	
	/****Métodos personalizados***/
	
	public Usuario findByUsuario(String usuario);
	public Usuario findByRol(String rol);
	

}
