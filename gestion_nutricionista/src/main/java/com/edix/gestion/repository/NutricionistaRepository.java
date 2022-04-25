package com.edix.gestion.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.entity.custom.NutricionistaFactGlobal;

@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Integer>{
	
	// Lista facturacion bruta y neta global y por hora con el tiempo trabajado de los nutricionistas buscando entre dos fechas
	@Query("SELECT new com.edix.gestion.entity.custom.NutricionistaFactGlobal"
					+ "(e.idNutricionista, e.nombre, e.apellidos, e.sueldo, sum(a.duracion) as minutos_trabajados,"
					+ " sum(a.precio) as facturacion_bruta,"
					+ " sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))) as facturacion_neta,"
					+ " (sum(a.precio))/(sum(a.duracion)/60) as facturacion_bruta_hora,"
					+ " (sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))))/(sum(a.duracion)/60) as facturacion_neta_hora,"
					+ " count(a.idConsulta) as numero_consultas)"
					+ " FROM Nutricionista e"
					+ " INNER JOIN Consulta a on a.nutricionista.idNutricionista = e.idNutricionista"
					+ " WHERE (a.fechaConsulta BETWEEN ?1 AND ?2)"
					+ " AND e.activo = 1"
					+ " GROUP BY e.idNutricionista")
	Optional<List<NutricionistaFactGlobal>> getAllFacturacionNutricionistas (Date fechaMin, Date fechaMax);
	
	
	// Lista facturacion bruta y neta global y por hora con el tiempo trabajado de los nutricionistas del mes actual(por defecto al cargar)
		@Query("SELECT new com.edix.gestion.entity.custom.NutricionistaFactGlobal"
						+ "(e.idNutricionista, e.nombre, e.apellidos, e.sueldo, sum(a.duracion) as minutos_trabajados,"
						+ " sum(a.precio) as facturacion_bruta,"
						+ " sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))) as facturacion_neta,"
						+ " (sum(a.precio))/(sum(a.duracion)/60) as facturacion_bruta_hora,"
						+ " (sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))))/(sum(a.duracion)/60) as facturacion_neta_hora,"
						+ " count(a.idConsulta) as numero_consultas)"
						+ " FROM Nutricionista e"
						+ " INNER JOIN Consulta a on a.nutricionista.idNutricionista = e.idNutricionista"
						+ " WHERE (a.fechaConsulta BETWEEN ?1 AND ?2)"
						+ " AND e.activo = 1"
						+ " GROUP BY e.idNutricionista")
		Optional<List<NutricionistaFactGlobal>> getAllFacturacionNutricionistasMesActual (Date fechaMin, Date fechaMax);
		
		
		// Facturacion bruta y neta global y por hora con el tiempo trabajado de un nutricionista del mes actual(por defecto al cargar)
				@Query("SELECT new com.edix.gestion.entity.custom.NutricionistaFactGlobal"
								+ "(e.idNutricionista, e.nombre, e.apellidos, e.sueldo, sum(a.duracion) as minutos_trabajados,"
								+ " sum(a.precio) as facturacion_bruta,"
								+ " sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))) as facturacion_neta,"
								+ " (sum(a.precio))/(sum(a.duracion)/60) as facturacion_bruta_hora,"
								+ " (sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))))/(sum(a.duracion)/60) as facturacion_neta_hora,"
								+ " count(a.idConsulta) as numero_consultas)"
								+ " FROM Nutricionista e"
								+ " INNER JOIN Consulta a on a.nutricionista.idNutricionista = e.idNutricionista"
								+ " WHERE (a.fechaConsulta BETWEEN ?2 AND ?3)"
								+ " AND e.activo = 1"
								+ " AND e.idNutricionista = ?1")
				Optional<NutricionistaFactGlobal> getFacturacionNutricionistaMesActual_Id (Integer id, Date fechaMin, Date fechaMax);
				
				
		// Facturacion bruta y neta global y por hora con el tiempo trabajado de un nutricionista entre dos fechas
				@Query("SELECT new com.edix.gestion.entity.custom.NutricionistaFactGlobal"
								+ "(e.idNutricionista, e.nombre, e.apellidos, e.sueldo, sum(a.duracion) as minutos_trabajados,"
								+ " sum(a.precio) as facturacion_bruta,"
								+ " sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))) as facturacion_neta,"
								+ " (sum(a.precio))/(sum(a.duracion)/60) as facturacion_bruta_hora,"
								+ " (sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))))/(sum(a.duracion)/60) as facturacion_neta_hora,"
								+ " count(a.idConsulta) as numero_consultas)"
								+ " FROM Nutricionista e"
								+ " INNER JOIN Consulta a on a.nutricionista.idNutricionista = e.idNutricionista"
								+ " WHERE (a.fechaConsulta BETWEEN ?1 AND ?2)"
								+ " AND e.activo = 1"
								+ " AND e.idNutricionista = ?3")
				Optional<NutricionistaFactGlobal> getFacturacionNutricionistaPorFecha_Id (Date fechaMin, Date fechaMax, Integer id);
	
				// Lista facturacion bruta y neta global y por hora con el tiempo trabajado de los nutricionistas del día actual(por defecto al cargar)
				@Query("SELECT new com.edix.gestion.entity.custom.NutricionistaFactGlobal"
								+ "(e.idNutricionista, e.nombre, e.apellidos, e.sueldo, sum(a.duracion) as minutos_trabajados,"
								+ " sum(a.precio) as facturacion_bruta,"
								+ " sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))) as facturacion_neta,"
								+ " (sum(a.precio))/(sum(a.duracion)/60) as facturacion_bruta_hora,"
								+ " (sum(a.precio) - (e.sueldo + sum(a.precio * (a.porcentajeVariable/100))))/(sum(a.duracion)/60) as facturacion_neta_hora,"
								+ " count(a.idConsulta) as numero_consultas)"
								+ " FROM Nutricionista e"
								+ " INNER JOIN Consulta a on a.nutricionista.idNutricionista = e.idNutricionista"
								+ " WHERE (a.fechaConsulta BETWEEN ?1 AND ?2)"
								+ " AND e.activo = 1"
								+ " GROUP BY e.idNutricionista")
				Optional<List<NutricionistaFactGlobal>> getAllFacturacionNutricionistasDiaActual (Date fechaMin, Date fechaMax);	
	

}
