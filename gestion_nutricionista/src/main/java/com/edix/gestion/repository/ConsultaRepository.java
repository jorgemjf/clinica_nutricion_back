package com.edix.gestion.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edix.gestion.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
	
	@Query
	("select c from Consulta c where c.nutricionista.idNutricionista = ?1")
	List<Consulta> findConsultasNutricionista(int idNutricionista);
	
	@Query
	("select c from Consulta c where c.nutricionista.idNutricionista = ?1 AND c.fechaConsulta =?2")
	List<Consulta> findConsultasNutricionistaFecha(int idNutricionista, Date fechaConsulta);

}
