package com.edix.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.edix.gestion.entity.Cliente;
import com.edix.gestion.entity.Consulta;
import com.edix.gestion.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepo;

	@Override
	public Cliente findById(int idCliente) {
		// TODO Auto-generated method stub
		return clienteRepo.findById(idCliente).orElse(null);
	}

	@Override
	public Optional<List<Cliente>> findAllClientes() {
		return Optional.of(((JpaRepository<Cliente, Integer>)clienteRepo).findAll());
	}

}
