package com.herrerachicaiza.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herrerachicaiza.backend.models.dao.IVoluntario;
import com.herrerachicaiza.backend.models.entities.Voluntario;
import com.herrerachicaiza.backend.services.interfaces.IVoluntarioService;

@Service
public class VoluntarioService implements IVoluntarioService {

	@Autowired
	private IVoluntario dao;
	
	@Override
	@Transactional
	public void save(Voluntario voluntario) {
		try {
			dao.save(voluntario);
			
		}catch(Exception ex) {
			throw ex;
		}
		
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Voluntario findById(Long id) {
		
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
	public List<Voluntario> findAll() {
		
		return (List<Voluntario>) dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Voluntario> findBySexo(String gender) {
		
		return dao.buscarPorSexo(gender);
	}

	@Override
	@Transactional(readOnly=true)
	public Voluntario findByApellido(String apellido) {
		
		return dao.buscarPorApellido(apellido);
	}

	@Override
	@Transactional(readOnly=true)
	public Voluntario findByCedula(String cedula) {
		
		return dao.buscarPorCedula(cedula);
	}

}
