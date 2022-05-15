package com.edix.gestion.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.gestion.dto.ConsultaDto;
import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.entity.Consulta;
import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.service.ConsultaService;
import com.edix.gestion.service.NutricionistaService;
import com.edix.gestion.utils.Transformation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/nutricionista")
public class NutricionistaController {

	@Autowired
	private NutricionistaService nutriService;

	@Autowired
	private ConsultaService cdao;

	@Autowired
	private Transformation transform;

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

	// Metodo para sacar todas las consultas por nutricionista
	@GetMapping("/consultas/{idNutricionista}")
	ResponseEntity<?> getConsultasNutricionista(@PathVariable(value = "idNutricionista") int idNutricionista) {

		List<ConsultaDto> consultaDto = null;

		try {
			Optional<List<Consulta>> consulta = cdao.findPorNutricionista(idNutricionista);

			if (consulta.isPresent()) {
				consultaDto = transform.listConsultaEntity_ConsultaDto(consulta.get());
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(consultaDto);
	}

	// Método para sacar todas las consultas por nutricionista según una fecha
	@GetMapping("/consultas/{idNutricionista}/{fechaConsulta}")
	ResponseEntity<?> getConsultasNutricionistaFecha(@PathVariable(value = "idNutricionista") int idNutricionista,
			@PathVariable(value = "fechaConsulta") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date fechaConsulta) {

		List<ConsultaDto> consultaDto = null;

		try {
			Optional<List<Consulta>> consulta = cdao.findPorNutricionistaFecha(idNutricionista, fechaConsulta);

			if (consulta.isPresent()) {
				consultaDto = transform.listConsultaEntity_ConsultaDto(consulta.get());
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(consultaDto);
	}
	
	@PostMapping("/consultas/alta")
	public String procesarAlta(@RequestBody Consulta consulta) {
		return (cdao.altaConsulta(consulta)) == 0 ? "Alta realizada" : "Alta no realizada";
	}

	// Método para actualizar una consulta a un nutricionista
	@PutMapping("/consultas/actualizar")
	public String procesarActualizacion(@RequestBody Consulta consulta) {
		return (cdao.updateConsulta(consulta)) == 0 ? "Actualización realizada" : "Actualización no realizada";
	}

	// Método para actualizar una consulta a un nutricionista
	@DeleteMapping("/consultas/eliminar/{idConsulta}")
	public String procesarRemove(@PathVariable int idConsulta) {
		return (cdao.eliminarConsulta(idConsulta) == 0) ? "Eliminación realizada" : "Eliminación no realizada";
	}

}
