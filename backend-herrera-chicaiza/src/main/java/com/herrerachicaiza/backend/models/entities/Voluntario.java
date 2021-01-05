package com.herrerachicaiza.backend.models.entities;

import java.io.Serializable;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name="Voluntarios")
@Entity
public class Voluntario extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id_vol")
	private Long idVoluntario;
	
	@Column(name="descripcion_vol", length=255)
	private String descripcion;
	
	@Column(name="fechaRegistro_vol", length=35)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar fechaRegistro;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_usuario", referencedColumnName = "id_usu")
	private Usuario usuario;

	@OneToMany(mappedBy="voluntario", fetch=FetchType.LAZY)
	private List<Registro> registro;
	
	public Voluntario() {
		super();
	}

	public Voluntario(Long idVoluntario) {
		super();
		this.idVoluntario = idVoluntario;
	}

	public Long getIdVoluntario() {
		return idVoluntario;
	}

	public void setIdVoluntario(Long idVoluntario) {
		this.idVoluntario = idVoluntario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Calendar fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(List<Registro> registro) {
		this.registro = registro;
	}
	
	

}
