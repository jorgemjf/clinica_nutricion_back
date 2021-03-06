package com.edix.gestion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the nutricionistas database table.
 * 
 */
@Entity
@Table(name="nutricionistas")
@NamedQuery(name="Nutricionista.findAll", query="SELECT n FROM Nutricionista n")
public class Nutricionista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_NUTRICIONISTA")
	private int idNutricionista;

	private int activo;

	private String apellidos;

	private String dni;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ALTA")
	private Date fechaAlta;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	private String nombre;

	private BigDecimal sueldo;

	private String telefono;

	//bi-directional many-to-one association to Consulta
	//@OneToMany(mappedBy="nutricionista")
	//private Set<Consulta> consultas;

	public Nutricionista() {
	}

	public int getIdNutricionista() {
		return this.idNutricionista;
	}

	public void setIdNutricionista(int idNutricionista) {
		this.idNutricionista = idNutricionista;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/*
	 * public Set<Consulta> getConsultas() { return this.consultas; }
	 * 
	 * public void setConsultas(Set<Consulta> consultas) { this.consultas =
	 * consultas; }
	 * 
	 * public Consulta addConsulta(Consulta consulta) {
	 * getConsultas().add(consulta); consulta.setNutricionista(this);
	 * 
	 * return consulta; }
	 * 
	 * public Consulta removeConsulta(Consulta consulta) {
	 * getConsultas().remove(consulta); consulta.setNutricionista(null);
	 * 
	 * return consulta; }
	 */

	public Nutricionista(int idNutricionista, String nombre, String apellidos, BigDecimal sueldo) {
		super();
		this.idNutricionista = idNutricionista;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
	}
	
	

}