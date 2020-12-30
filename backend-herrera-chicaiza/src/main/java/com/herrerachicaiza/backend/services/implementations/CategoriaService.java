package com.herrerachicaiza.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herrerachicaiza.backend.models.dao.ICategoria;
import com.herrerachicaiza.backend.models.entities.Categoria;
import com.herrerachicaiza.backend.services.interfaces.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService {
	
	@Autowired
	private ICategoria dao;

	@Override
	@Transactional(readOnly=true)
	public Categoria findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>) dao.findAll();
	}

}
