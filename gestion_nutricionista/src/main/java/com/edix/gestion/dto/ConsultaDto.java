package com.edix.gestion.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConsultaDto {
	
	private int idConsulta;

	private int duracion;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "es_ES", timezone = "Europe/Madrid")
	private Date fechaConsulta;
	
	private BigDecimal porcentajeVariable;

	private BigDecimal precio;
	
	private BonoDto bono;
	
	private ClienteDto cliente;
	
	private NutricionistaDto nutricionista;

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public BigDecimal getPorcentajeVariable() {
		return porcentajeVariable;
	}

	public void setPorcentajeVariable(BigDecimal porcentajeVariable) {
		this.porcentajeVariable = porcentajeVariable;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BonoDto getBono() {
		return bono;
	}

	public void setBono(BonoDto bono) {
		this.bono = bono;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public NutricionistaDto getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(NutricionistaDto nutricionista) {
		this.nutricionista = nutricionista;
	}
	
	

}
