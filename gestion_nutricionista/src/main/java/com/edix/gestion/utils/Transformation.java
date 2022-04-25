package com.edix.gestion.utils;

import java.util.List;

import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.dto.custom.NutricionistaFactGlobalDto;
import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.entity.custom.NutricionistaFactGlobal;

public interface Transformation {
	
	List<NutricionistaDto> listNutricionistaEntity_NutricionistaDto(List<Nutricionista> nutricionistas);
	
	NutricionistaDto nutricionistaEntity_NutricionistaDto(Nutricionista nutricionista);
	
	List<NutricionistaFactGlobalDto> listNutricionistaFactGlobal_NutricionistaFactGlobalDto(List<NutricionistaFactGlobal> nutricionistas);
	
	NutricionistaFactGlobalDto nutricionistaFactGlobal_NutricionistaFactGlobalDto (NutricionistaFactGlobal nutricionista);

}
