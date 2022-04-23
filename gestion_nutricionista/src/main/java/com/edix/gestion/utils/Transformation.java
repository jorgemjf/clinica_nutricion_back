package com.edix.gestion.utils;

import java.util.List;

import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.entity.Nutricionista;

public interface Transformation {
	
	List<NutricionistaDto> listNutricionistaEntity_NutricionistaDto(List<Nutricionista> nutricionistas);
	
	NutricionistaDto nutricionistaEntity_NutricionistaDto(Nutricionista nutricionista);

}
