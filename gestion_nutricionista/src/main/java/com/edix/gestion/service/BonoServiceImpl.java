package com.edix.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.edix.gestion.entity.Bono;
import com.edix.gestion.entity.Consulta;
import com.edix.gestion.repository.BonoRepository;

@Service
public class BonoServiceImpl implements BonoService{
	
	@Autowired
	private BonoRepository bonoRepo;

	@Override
	public Bono findById(int idBono) {
		// TODO Auto-generated method stub
		return bonoRepo.findById(idBono).orElse(null);
	}

	@Override
	public Optional<List<Bono>> findAllBonos() {
		return Optional.of(((JpaRepository<Bono, Integer>)bonoRepo).findAll());
	}

}
