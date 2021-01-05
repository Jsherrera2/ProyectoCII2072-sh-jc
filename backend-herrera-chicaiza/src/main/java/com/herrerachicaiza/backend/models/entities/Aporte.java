package com.herrerachicaiza.backend.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="Aportes")
@Entity
public class Aporte implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_apo")
	private Long idAporte;
	
	@Column(name="numHoras_apo", length=1)
	private int numHoras;
	
	@Column(name="disponibilidad_apo", length=255)
	private String disponibilidad;

	@OneToMany(mappedBy="aporte", fetch=FetchType.LAZY)
	private List<Evento> eventos;
	
	
	public Aporte() {
		super();
	}

	public Aporte(Long idAporte) {
		super();
		this.idAporte = idAporte;
	}

	public Long getIdAporte() {
		return idAporte;
	}

	public void setIdAporte(Long idAporte) {
		this.idAporte = idAporte;
	}

	public int getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
	

}
