package com.herrerachicaiza.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.herrerachicaiza.backend.models.dao.IEvento;
import com.herrerachicaiza.backend.models.entities.Evento;
import com.herrerachicaiza.backend.services.interfaces.IEventoService;

public class EventoService implements IEventoService {

	@Autowired
	private IEvento dao;
	
	@Override
	@Transactional
	
	public void save(Evento evento) {
		
		try {
			dao.save(evento);
			
		}catch(Exception ex) {
			throw ex;
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public Evento findById(Long id) {
	
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
	public List<Evento> findAll() {
		return (List<Evento>) dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Evento findByNombre(String nombre) {
		return dao.buscarPorNombre(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Evento> findByCategoria(String categoria) {
		return dao.buscarPorCategoria(categoria);
	}



}
