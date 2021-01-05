package com.herrerachicaiza.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.herrerachicaiza.backend.models.dao.IRegistro;

import com.herrerachicaiza.backend.models.entities.Registro;
import com.herrerachicaiza.backend.services.interfaces.IRegistroService;

public class RegistroService implements IRegistroService {
	@Autowired
	private IRegistro dao;
	
	@Override
	@Transactional
	public void save(Registro registro) {
     
		try {
			dao.save(registro);
			
		}catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Registro findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {

		try {
			dao.deleteById(id);
			
		}catch(Exception ex) {
			throw ex;
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Registro> findAll() {
		return (List<Registro>) dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Registro> findByEstado(String estado) {
		return dao.buscarPorEstado(estado);
	}

	

}
