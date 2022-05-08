package com.edix.gestion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.edix.gestion.entity.Consulta;

public interface ConsultaService {
	
		// Lista de todas las consultas
		Optional<List<Consulta>> findAllConsultas();
		
		// Lista de consultas por nutricionista
		Optional<List<Consulta>> findPorNutricionista(int idNutricionista);
		
		// Lista de consultas por nutricionista
		Optional<List<Consulta>> findPorNutricionistaFecha(int idNutricionista, Date fechaConsulta);
			
		//Encontrar la consulta por id
		Consulta findById(int idConsulta);
		
		//Alta consulta
		int altaConsulta(Consulta consulta);

		int updateConsulta(Consulta consulta);
		
		int eliminarConsulta (int idConsulta);
		

}
