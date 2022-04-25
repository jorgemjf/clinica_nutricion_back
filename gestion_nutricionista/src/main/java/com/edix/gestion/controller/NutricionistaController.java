package com.edix.gestion.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.dto.custom.NutricionistaFactGlobalDto;
import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.entity.custom.NutricionistaFactGlobal;
import com.edix.gestion.service.NutricionistaService;
import com.edix.gestion.utils.Transformation;

@RestController
@RequestMapping(value= "/nutricionistas")
public class NutricionistaController {
	
	@Autowired
	private NutricionistaService nutriService;
	
	@Autowired
	private Transformation transform;
	
	
	// Metodo para sacar informacion de todos los nutricionistas
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
	
	// Metodo para buscar informacion por nutricionista
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
	
	//Metodo para sacar la facturacion global y por horas de cada nutricionista
	@GetMapping(value = "/facturacion")
	ResponseEntity<?> getFacturacionNutricionistasPorFecha(@RequestParam(name = "fechaMin") Date fechaMin, @RequestParam(name = "fechaMax") Date fechaMax){
		
		List<NutricionistaFactGlobalDto> nutriFactGlobalDto = null;
		
		try {
				
			Optional<List<NutricionistaFactGlobal>> facturacionNutricionistas = nutriService.getAllFacturacionDeNutricionistas(fechaMin, fechaMax);
			
			if (facturacionNutricionistas.isPresent()) {
				nutriFactGlobalDto = transform.listNutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionistas.get());
			} else {
				return ResponseEntity.notFound().build();
			}
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(nutriFactGlobalDto);
	}
	
	//Metodo para sacar la facturacion global y por horas de cada nutricionista del mes actual
		@GetMapping(value = "/facturacion/mensual")
		ResponseEntity<?> getFacturacionNutricionistasMesActual(){
			
			List<NutricionistaFactGlobalDto> nutriFactGlobalDto = null;
			
			try {
					
				Optional<List<NutricionistaFactGlobal>> facturacionNutricionistas = nutriService.getAllFacturacionDeNutricionistasMesActual();
				
				if (facturacionNutricionistas.isPresent()) {
					nutriFactGlobalDto = transform.listNutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionistas.get());
				} else {
					return ResponseEntity.notFound().build();
				}
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			
			return ResponseEntity.ok(nutriFactGlobalDto);
		}
		
		//Metodo para sacar la facturacion global y por horas de un nutricionista del mes actual
		@GetMapping(value = "/facturacion/{id}")
		ResponseEntity<?> getFacturacionDeUnNutricionistasMesActual(@PathVariable(value = "id") int id){
			
			NutricionistaFactGlobalDto nutriFactGlobalDto = null;
			
			try {
					
				Optional<NutricionistaFactGlobal> facturacionNutricionista = nutriService.getFacturacionNutricionistaMesActual(id);
				
				if (facturacionNutricionista.isPresent()) {
					nutriFactGlobalDto = transform.nutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionista.get());
				} else {
					return ResponseEntity.notFound().build();
				}
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			
			return ResponseEntity.ok(nutriFactGlobalDto);
		}
		
		//Metodo para sacar la facturacion global y por horas de un nutricionista por fecha
		@GetMapping(value = "/facturacion/{id}/mensual")
		ResponseEntity<?> getFacturacionDeUnNutricionistasPorFecha(@RequestParam(name = "fechaMin") Date fechaMin, @RequestParam(name = "fechaMax") Date fechaMax, @PathVariable(value = "id") int id){
			
			NutricionistaFactGlobalDto nutriFactGlobalDto = null;
			
			try {
					
				Optional<NutricionistaFactGlobal> facturacionNutricionista = nutriService.getFacturacionNutricionistaPorFecha(fechaMin, fechaMax, id);
				
				if (facturacionNutricionista.isPresent()) {
					nutriFactGlobalDto = transform.nutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionista.get());
				} else {
					return ResponseEntity.notFound().build();
				}
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			
			return ResponseEntity.ok(nutriFactGlobalDto);
		}
		
		//Metodo para sacar la facturacion global y por horas de cada nutricionista del mes actual
		@GetMapping(value = "/facturacion/diaria")
		ResponseEntity<?> getFacturacionNutricionistasDiaActual(){
			
			List<NutricionistaFactGlobalDto> nutriFactGlobalDto = null;
			
			try {
					
				Optional<List<NutricionistaFactGlobal>> facturacionNutricionistas = nutriService.getAllFacturacionDeNutricionistasDiaActual();
				
				if (facturacionNutricionistas.isPresent()) {
					nutriFactGlobalDto = transform.listNutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionistas.get());
				} else {
					return ResponseEntity.notFound().build();
				}
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			
			return ResponseEntity.ok(nutriFactGlobalDto);
		}


}
