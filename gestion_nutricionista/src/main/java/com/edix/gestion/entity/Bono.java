package com.edix.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the bonos database table.
 * 
 */
@Entity
@Table(name="bonos")
@NamedQuery(name="Bono.findAll", query="SELECT b FROM Bono b")
public class Bono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BONO")
	private int idBono;

	private int activo;

	@Column(name="CANTIDAD_CONSULTAS")
	private int cantidadConsultas;

	@Column(name="CONSULTAS_RESTANTES")
	private int consultasRestantes;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ALTA")
	private Date fechaAlta;

	//uni-directional many-to-one association to Cliente
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="ID_CLIENTE")
	//private Cliente cliente;

	public Bono() {
	}

	public int getIdBono() {
		return this.idBono;
	}

	public void setIdBono(int idBono) {
		this.idBono = idBono;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getCantidadConsultas() {
		return this.cantidadConsultas;
	}

	public void setCantidadConsultas(int cantidadConsultas) {
		this.cantidadConsultas = cantidadConsultas;
	}

	public int getConsultasRestantes() {
		return this.consultasRestantes;
	}

	public void setConsultasRestantes(int consultasRestantes) {
		this.consultasRestantes = consultasRestantes;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/*
	 * public Cliente getCliente() { return this.cliente; }
	 * 
	 * public void setCliente(Cliente cliente) { this.cliente = cliente; }
	 */

}