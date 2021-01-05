package com.herrerachicaiza.backend.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name="Registros")
@Entity
public class Registro  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="id_reg")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Long idRegistro;
	
	@Column(name="fecha_reg")	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar fecha;
	
	@Column(name="estado_reg")
	private String estado;
	
	@JoinColumn(name="fk_evento",referencedColumnName="id_eve")
	@ManyToOne
	private Evento evento;
	@JoinColumn(name="fk_voluntario",referencedColumnName="id_vol")
	@ManyToOne
	private Voluntario voluntario;
}
