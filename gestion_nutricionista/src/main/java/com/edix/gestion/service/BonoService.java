package com.edix.gestion.service;

import java.util.List;
import java.util.Optional;

import com.edix.gestion.entity.Bono;

public interface BonoService {
	
	//Encontrar la consulta por id
	Bono findById(int idBono);
	
	// Lista de todas las consultas
	Optional<List<Bono>> findAllBonos();

}
