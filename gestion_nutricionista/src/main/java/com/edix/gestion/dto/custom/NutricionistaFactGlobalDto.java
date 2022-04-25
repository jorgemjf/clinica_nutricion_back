package com.edix.gestion.dto.custom;

import java.math.BigDecimal;

import com.edix.gestion.entity.Nutricionista;

	public class NutricionistaFactGlobalDto {
	
	private Nutricionista nutricionista;
	
	private Long minutos_trabajados;
	
	private BigDecimal facturacion_bruta;
	
	private BigDecimal facturacion_neta;
	
	private BigDecimal facturacion_bruta_hora;
	
	private BigDecimal facturacion_neta_hora;
	
	private Long numero_consultas;

	public NutricionistaFactGlobalDto() {
		super();
	}

	public NutricionistaFactGlobalDto(Nutricionista nutricionista, Long minutos_trabajados,
			BigDecimal facturacion_bruta, BigDecimal facturacion_neta, BigDecimal facturacion_bruta_hora,
			BigDecimal facturacion_neta_hora, Long numero_consultas) {
		super();
		this.nutricionista = nutricionista;
		this.minutos_trabajados = minutos_trabajados;
		this.facturacion_bruta = facturacion_bruta;
		this.facturacion_neta = facturacion_neta;
		this.facturacion_bruta_hora = facturacion_bruta_hora;
		this.facturacion_neta_hora = facturacion_neta_hora;
		this.numero_consultas = numero_consultas;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	public Long getMinutos_trabajados() {
		return minutos_trabajados;
	}

	public void setMinutos_trabajados(Long minutos_trabajados) {
		this.minutos_trabajados = minutos_trabajados;
	}

	public BigDecimal getFacturacion_bruta() {
		return facturacion_bruta;
	}

	public void setFacturacion_bruta(BigDecimal facturacion_bruta) {
		this.facturacion_bruta = facturacion_bruta;
	}

	public BigDecimal getFacturacion_neta() {
		return facturacion_neta;
	}

	public void setFacturacion_neta(BigDecimal facturacion_neta) {
		this.facturacion_neta = facturacion_neta;
	}

	public BigDecimal getFacturacion_bruta_hora() {
		return facturacion_bruta_hora;
	}

	public void setFacturacion_bruta_hora(BigDecimal facturacion_bruta_hora) {
		this.facturacion_bruta_hora = facturacion_bruta_hora;
	}

	public BigDecimal getFacturacion_neta_hora() {
		return facturacion_neta_hora;
	}

	public void setFacturacion_neta_hora(BigDecimal facturacion_neta_hora) {
		this.facturacion_neta_hora = facturacion_neta_hora;
	}

	public Long getNumero_consultas() {
		return numero_consultas;
	}

	public void setNumero_consultas(Long numero_consultas) {
		this.numero_consultas = numero_consultas;
	}
	
	

}
