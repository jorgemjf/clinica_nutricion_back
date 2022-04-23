package com.edix.gestion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.service.NutricionistaService;
import com.edix.gestion.utils.Transformation;

@RestController
@RequestMapping(value= "/nutricionistas")
public class NutricionistaController {
	
	@Autowired
	private NutricionistaService nutriService;
	
	@Autowired
	private Transformation transform;
	
	@GetMapping("")
	ResponseEntity<?> getAllNutricionistas() {
		
		List<NutricionistaDto> nutricionistaDto = null;
		
		try {
			
			Optional<List<Nutricionista>> nutricionistas = nutriService.findAllNutricionistas();
			
			if(nutricionistas.isPresent()) {
					nutricionistaDto = transform.listNutricionistaEntity_NutricionistaDto(nutricionistas.get());
			} else {
					return ResponseEntity.notFound().build();
			}
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(nutricionistaDto);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> getNutricionista(@PathVariable(value = "id") int id) {
		
		NutricionistaDto nutricionistaDto = null;
		
		try {
			
			Optional<Nutricionista> nutricionista = nutriService.findNutricionista(id);
			
			if (nutricionista.isPresent()) {
				nutricionistaDto = transform.nutricionistaEntity_NutricionistaDto(nutricionista.get());
			} else {
				return ResponseEntity.notFound().build();
			}
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(nutricionistaDto);
	}

}
