package com.herrerachicaiza.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herrerachicaiza.backend.models.dao.IAporte;
import com.herrerachicaiza.backend.models.entities.Aporte;
import com.herrerachicaiza.backend.services.interfaces.IAporteService;

@Service
public class AporteService implements IAporteService {
	
	@Autowired
	private IAporte dao;

	@Override
	@Transactional(readOnly=true)
	public Aporte findById(Long id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Aporte> findAll() {
		
		return (List<Aporte>) dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Aporte findByDisponibilidad(String disponibilidad) {
		
		return dao.buscarPorDisponibilidad(disponibilidad);
	}

}
