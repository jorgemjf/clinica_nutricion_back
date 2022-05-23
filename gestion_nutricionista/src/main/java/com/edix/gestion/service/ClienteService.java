package com.edix.gestion.service;

import java.util.List;
import java.util.Optional;

import com.edix.gestion.entity.Cliente;

public interface ClienteService {
	
	//Encontrar la consulta por id
	Cliente findById(int idCliente);
	
	// Lista de todas las consultas
	Optional<List<Cliente>> findAllClientes();

}
