package com.edix.gestion.utils;

import java.util.List;

import com.edix.gestion.dto.ConsultaDto;
import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.dto.custom.NutricionistaFactGlobalDto;
import com.edix.gestion.entity.Consulta;
import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.entity.custom.NutricionistaFactGlobal;

public interface Transformation {
	
	List<NutricionistaDto> listNutricionistaEntity_NutricionistaDto(List<Nutricionista> nutricionistas);
	
	NutricionistaDto nutricionistaEntity_NutricionistaDto(Nutricionista nutricionista);
	
	List<NutricionistaFactGlobalDto> listNutricionistaFactGlobal_NutricionistaFactGlobalDto(List<NutricionistaFactGlobal> nutricionistas);
	
	NutricionistaFactGlobalDto nutricionistaFactGlobal_NutricionistaFactGlobalDto (NutricionistaFactGlobal nutricionista);
	
	// Lista de consultas
	List<ConsultaDto> listConsultaEntity_ConsultaDto(List<Consulta> consultas);

	// Obtiene la clase de la consulta y la convierte a DTO
	ConsultaDto consultaEntity_consultaDto(Consulta consulta);

}
