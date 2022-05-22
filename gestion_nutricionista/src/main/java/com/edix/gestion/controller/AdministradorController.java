package com.edix.gestion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edix.gestion.dto.ConsultaDto;
import com.edix.gestion.dto.NutricionistaDto;
import com.edix.gestion.dto.custom.NutricionistaFactGlobalDto;
import com.edix.gestion.entity.Consulta;
import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.entity.custom.NutricionistaFactGlobal;
import com.edix.gestion.service.ConsultaService;
import com.edix.gestion.service.NutricionistaService;
import com.edix.gestion.utils.Transformation;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/gestion")
public class AdministradorController {

	@Autowired
	private ConsultaService cdao;
	
	@Autowired
	private NutricionistaService nutriService;

	@Autowired
	private Transformation transform;

// Metodo para sacar todas las consultas
	@GetMapping("")
	ResponseEntity<?> getAllConsultas() {
		List<ConsultaDto> consultaDto = null;

		try {

			Optional<List<Consulta>> consultas = cdao.findAllConsultas();

			if (consultas.isPresent()) {
				consultaDto = transform.listConsultaEntity_ConsultaDto(consultas.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(consultaDto);
	}
	
	// Metodo para buscar informacion por consulta
		@GetMapping("/consulta/{id}")
		ResponseEntity<?> getConsulta(@PathVariable(value = "id") int id) {

			ConsultaDto consultaDto = null;

			try {

				Optional<Consulta> consulta = Optional.ofNullable(cdao.findById(id));

				if (consulta.isPresent()) {
					consultaDto = transform.consultaEntity_consultaDto(consulta.get());
				} else {
					return ResponseEntity.notFound().build();
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			}

			return ResponseEntity.ok(consultaDto);
		}

	// Metodo para sacar todas las consultas por nutricionista
	@GetMapping("/nutricionista/consultas/{idNutricionista}")
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

//Método para sacar todas las consultas por nutricionista según una fecha
	@GetMapping("/nutricionista/consultas/{idNutricionista}/{fechaConsulta}")
	ResponseEntity<?> getConsultasNutricionistaFecha(@PathVariable(value = "idNutricionista") int idNutricionista,
			@PathVariable(value = "fechaConsulta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaConsulta) {
		System.out.println(idNutricionista);
		System.out.println(fechaConsulta);
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
		System.out.println(consultaDto);
		return ResponseEntity.ok(consultaDto);
	}

	// Método para asignar una consulta a un nutricionista
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

	// Metodo para sacar informacion de todos los nutricionistas
	@GetMapping("/nutricionista")
	ResponseEntity<?> getAllNutricionistas() {

		List<NutricionistaDto> nutricionistaDto = null;

		try {

			Optional<List<Nutricionista>> nutricionistas = nutriService.findAllNutricionistas();

			if (nutricionistas.isPresent()) {
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
	@GetMapping("/nutricionista/{id}")
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

	// Metodo para sacar la facturacion global y por horas de cada nutricionista entre dos fechas
	@GetMapping(value = "/facturacion")
	ResponseEntity<?> getFacturacionNutricionistasPorFecha(@RequestParam(name = "fechaMin") Date fechaMin,
			@RequestParam(name = "fechaMax") Date fechaMax) {
		System.out.println("fechaMax" + fechaMax);
		System.out.println("fechaMax" + fechaMin);

		List<NutricionistaFactGlobalDto> nutriFactGlobalDto = null;

		try {

			Optional<List<NutricionistaFactGlobal>> facturacionNutricionistas = nutriService
					.getAllFacturacionDeNutricionistas(fechaMin, fechaMax);

			if (facturacionNutricionistas.isPresent()) {
				nutriFactGlobalDto = transform
						.listNutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionistas.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(nutriFactGlobalDto);
	}

	// Metodo para sacar la facturacion global y por horas de cada nutricionista del
	// mes actual
	@GetMapping(value = "/facturacion/mensual")
	ResponseEntity<?> getFacturacionNutricionistasMesActual() {

		List<NutricionistaFactGlobalDto> nutriFactGlobalDto = null;

		try {

			Optional<List<NutricionistaFactGlobal>> facturacionNutricionistas = nutriService
					.getAllFacturacionDeNutricionistasMesActual();

			if (facturacionNutricionistas.isPresent()) {
				nutriFactGlobalDto = transform
						.listNutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionistas.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(nutriFactGlobalDto);
	}

	// Metodo para sacar la facturacion global y por horas de un nutricionista del
	// mes actual
	@GetMapping(value = "/facturacion/nutricionista/{id}")
	ResponseEntity<?> getFacturacionDeUnNutricionistasMesActual(@PathVariable(value = "id") int id) {

		NutricionistaFactGlobalDto nutriFactGlobalDto = null;

		try {

			Optional<NutricionistaFactGlobal> facturacionNutricionista = nutriService
					.getFacturacionNutricionistaMesActual(id);

			if (facturacionNutricionista.isPresent()) {
				nutriFactGlobalDto = transform
						.nutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionista.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(nutriFactGlobalDto);
	}

	// Metodo para sacar la facturacion global y por horas de un nutricionista por
	// fecha
	@GetMapping(value = "/facturacion/nutricionista/{id}/mensual")
	ResponseEntity<?> getFacturacionDeUnNutricionistasPorFecha(@RequestParam(name = "fechaMin") Date fechaMin,
			@RequestParam(name = "fechaMax") Date fechaMax, @PathVariable(value = "id") int id) {

		NutricionistaFactGlobalDto nutriFactGlobalDto = null;

		try {

			Optional<NutricionistaFactGlobal> facturacionNutricionista = nutriService
					.getFacturacionNutricionistaPorFecha(fechaMin, fechaMax, id);

			if (facturacionNutricionista.isPresent()) {
				nutriFactGlobalDto = transform
						.nutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionista.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(nutriFactGlobalDto);
	}

	// Metodo para sacar la facturacion global y por horas de cada nutricionista del
	// día actual
	@GetMapping(value = "/facturacion/diaria")
	ResponseEntity<?> getFacturacionNutricionistasDiaActual() {

		List<NutricionistaFactGlobalDto> nutriFactGlobalDto = null;

		try {

			Optional<List<NutricionistaFactGlobal>> facturacionNutricionistas = nutriService
					.getAllFacturacionDeNutricionistasDiaActual();

			if (facturacionNutricionistas.isPresent()) {
				nutriFactGlobalDto = transform
						.listNutricionistaFactGlobal_NutricionistaFactGlobalDto(facturacionNutricionistas.get());
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(nutriFactGlobalDto);
	}

	// Metodo para añadir nutricionista
	@PostMapping("/nutricionista/alta")
    public String procesarAltaNutricionista(@RequestBody Nutricionista nutricionista) {
        return (nutriService.altaNutricionista(nutricionista)) == 0 ? "Alta realizada" : "Alta no realizada";
    }

	//Metodo para editar un nutricionista
    @PutMapping("/nutricionista/actualizar")
    public String procesarActualizacionNutricionista(@RequestBody Nutricionista nutricionista) {
        return (nutriService.updateNutricionista(nutricionista)) == 0 ? "Actualización realizada"
                : "Actualización no realizada";
    }

	// Metodo para eliminar un nutricionista
    @DeleteMapping("/nutricionista/eliminar/{idNutricionista}")
    public String procesarEliminacionNutricionista(@PathVariable int idNutricionista) {
        return (nutriService.eliminarNutricionista(idNutricionista)) == 0 ? "Eliminacion realizada"
                : "Eliminacion no realizada";
    }

	// Metodo para formatear la fecha a formato web y evitar errores de conversion
	// de tipo String a tipo Date
	@InitBinder
	public void initBinder (WebDataBinder webdataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webdataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
}
