package com.edix.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edix.gestion.entity.Bono;

@Repository
public interface BonoRepository extends JpaRepository<Bono, Integer>{

}
