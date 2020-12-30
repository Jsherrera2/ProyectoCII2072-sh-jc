package com.herrerachicaiza.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.herrerachicaiza.backend.models.entities.Categoria;

public interface ICategoria extends CrudRepository<Categoria, Long>{

}
