package com.edix.gestion.service;

import java.util.List;
import java.util.Optional;

import com.edix.gestion.entity.Nutricionista;

public interface NutricionistaService {
	
	Optional<List<Nutricionista>> findAllNutricionistas();
	
	Optional<Nutricionista> findNutricionista(Integer id);
	

}
