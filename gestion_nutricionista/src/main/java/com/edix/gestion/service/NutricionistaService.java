package com.edix.gestion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.entity.custom.NutricionistaFactGlobal;

public interface NutricionistaService {
	
	Optional<List<Nutricionista>> findAllNutricionistas();
	
	Optional<Nutricionista> findNutricionista(Integer id);
	
	Optional<List<NutricionistaFactGlobal>> getAllFacturacionDeNutricionistas(Date fechaMin, Date fechaMax);
	
	Optional<List<NutricionistaFactGlobal>> getAllFacturacionDeNutricionistasMesActual();
	
	Optional<NutricionistaFactGlobal> getFacturacionNutricionistaMesActual(Integer id);
	
	Optional<NutricionistaFactGlobal> getFacturacionNutricionistaPorFecha(Date fechaMin, Date fechaMax, Integer id);
	
	Optional<List<NutricionistaFactGlobal>> getAllFacturacionDeNutricionistasDiaActual();
	

}
