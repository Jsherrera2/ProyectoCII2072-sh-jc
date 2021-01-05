package com.herrerachicaiza.backend.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;




@Table(name="Eventos")
@Entity
public class Evento implements Serializable {
private static final long serialVersionUID=1L;
@Id
@Column(name="id_eve")
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
private Long idEvento;

@Column(name="nombre_eve")
private String nombre;

@Column(name="fechaInicio_eve")	
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Calendar fechaInicio;

@Column(name="fechaFinal_eve")	
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Calendar fechaFinal;

@Column(name="organizador_eve")
private String organizador;

@JoinColumn(name="fk_categoria",referencedColumnName="id_cat")
@ManyToOne
private Categoria categoria;

@JoinColumn(name="fk_aporte",referencedColumnName="id_apo")
@ManyToOne
private Aporte aporte;

@OneToMany(mappedBy="evento", fetch=FetchType.LAZY)
private List<Registro> registro;

public Evento(){	
	super();
}
public Evento(Long id){	
	super();
	this.idEvento=id;
}
public Long getIdEvento() {
	return idEvento;
}
public void setIdEvento(Long idEvento) {
	this.idEvento = idEvento;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Calendar getFechaInicio() {
	return fechaInicio;
}
public void setFechaInicio(Calendar fechaInicio) {
	this.fechaInicio = fechaInicio;
}
public Calendar getFechaFinal() {
	return fechaFinal;
}
public void setFechaFinal(Calendar fechaFinal) {
	this.fechaFinal = fechaFinal;
}
public String getOrganizador() {
	return organizador;
}
public void setOrganizador(String organizador) {
	this.organizador = organizador;
}
public Categoria getCategoria() {
	return categoria;
}
public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}
public Aporte getAporte() {
	return aporte;
}
public void setAporte(Aporte aporte) {
	this.aporte = aporte;
}
public List<Registro> getRegistro() {
	return registro;
}
public void setRegistro(List<Registro> registro) {
	this.registro = registro;
}


}
