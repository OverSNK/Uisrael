package com.gestioncomputador.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncomputador.entity.Computadora;

@Repository
public interface ComputadoraRepository extends JpaRepository<Computadora,Integer>{
	
}