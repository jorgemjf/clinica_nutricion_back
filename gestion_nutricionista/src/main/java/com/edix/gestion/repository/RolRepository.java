package com.edix.gestion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.gestion.entity.Perfile;

public interface RolRepository extends JpaRepository<Perfile, Long>{
	
	public Optional<Perfile> findByNombre(String nombre);

}
