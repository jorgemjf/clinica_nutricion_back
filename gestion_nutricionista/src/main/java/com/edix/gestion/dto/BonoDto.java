package com.edix.gestion.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BonoDto {
	
	private int idBono;

	private int activo;
	
	private int cantidadConsultas;
	
	private int consultasRestantes;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "es_ES", timezone = "Europe/Madrid")
	private Date fechaAlta;
	
	private ClienteDto cliente;

	public int getIdBono() {
		return idBono;
	}

	public void setIdBono(int idBono) {
		this.idBono = idBono;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getCantidadConsultas() {
		return cantidadConsultas;
	}

	public void setCantidadConsultas(int cantidadConsultas) {
		this.cantidadConsultas = cantidadConsultas;
	}

	public int getConsultasRestantes() {
		return consultasRestantes;
	}

	public void setConsultasRestantes(int consultasRestantes) {
		this.consultasRestantes = consultasRestantes;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}
	
	

}
