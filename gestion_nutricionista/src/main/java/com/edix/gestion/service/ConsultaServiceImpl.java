package com.edix.gestion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.edix.gestion.entity.Consulta;
import com.edix.gestion.repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService{
	
	@Autowired
	private ConsultaRepository crepo;

	//Encuentra la lista de consultas
	@Override
	public Optional<List<Consulta>> findAllConsultas() {
		return Optional.of(((JpaRepository<Consulta, Integer>)crepo).findAll());
	}

	//Encuentra la lista de consultas por id de nutricionista
	@Override
	public Optional<List<Consulta>> findPorNutricionista(int idNutricionista) {
		return Optional.of(crepo.findConsultasNutricionista(idNutricionista));
	}

	//Encuentra la lista de consultas por id de nutricionista y fecha
	@Override
	public Optional<List<Consulta>> findPorNutricionistaFecha(int idNutricionista, Date fechaConsulta) {
		return Optional.of(crepo.findConsultasNutricionistaFecha(idNutricionista, fechaConsulta));
	}

	//Encuentra una consulta por id
	@Override
	public Consulta findById(int idConsulta) {
		return crepo.findById(idConsulta).orElse(null);
	}
	
	//Inserta una consulta en la base de datos
	@Override
	public int altaConsulta(Consulta consulta) {
		if (findById(consulta.getIdConsulta()) == null) {
			crepo.save(consulta);
			return 0;
		}
		return 1;
	}
 
	@Override
	public int updateConsulta(Consulta consulta) {
		if (findById(consulta.getIdConsulta()) != null) {
			crepo.save(consulta);
			return 0;
		}
		return 1;
	}
	 
	@Override
	public int eliminarConsulta(int idConsulta) {
		if (findById(idConsulta) != null) {
			crepo.deleteById(idConsulta);
			return 0;
		}
		return 1;
	}

}
