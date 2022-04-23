package com.edix.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the consultas database table.
 * 
 */
@Entity
@Table(name="consultas")
@NamedQuery(name="Consulta.findAll", query="SELECT c FROM Consulta c")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CONSULTA")
	private int idConsulta;

	private int duracion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_CONSULTA")
	private Date fechaConsulta;

	@Column(name="PORCENTAJE_VARIABLE")
	private BigDecimal porcentajeVariable;

	private BigDecimal precio;

	//uni-directional many-to-one association to Bono
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_BONO")
	private Bono bono;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Nutricionista
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_NUTRICIONISTA")
	private Nutricionista nutricionista;

	public Consulta() {
	}

	public int getIdConsulta() {
		return this.idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaConsulta() {
		return this.fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public BigDecimal getPorcentajeVariable() {
		return this.porcentajeVariable;
	}

	public void setPorcentajeVariable(BigDecimal porcentajeVariable) {
		this.porcentajeVariable = porcentajeVariable;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Bono getBono() {
		return this.bono;
	}

	public void setBono(Bono bono) {
		this.bono = bono;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Nutricionista getNutricionista() {
		return this.nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

}