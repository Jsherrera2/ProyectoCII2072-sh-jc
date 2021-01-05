package com.herrerachicaiza.backend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herrerachicaiza.backend.models.dao.IUsuario;
import com.herrerachicaiza.backend.models.entities.Usuario;
import com.herrerachicaiza.backend.services.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuario dao;
	
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsuario(String usuario) {
		return dao.buscarPorUsuario(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByRol(String rol) {
		return dao.buscarPorRol(rol);
	}

}
