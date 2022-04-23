package com.edix.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.edix.gestion.entity.Nutricionista;
import com.edix.gestion.repository.NutricionistaRepository;

@Service
public class NutricionistaServiceImpl implements NutricionistaService{
	
	@Autowired
	private NutricionistaRepository nutriRepo;

	@Override
	public Optional<List<Nutricionista>> findAllNutricionistas() {
		return Optional.of(((JpaRepository<Nutricionista, Integer>) nutriRepo).findAll());
	}

	@Override
	public Optional<Nutricionista> findNutricionista(Integer id) {
		return ((CrudRepository<Nutricionista, Integer>) nutriRepo).findById(id);
	}

}
