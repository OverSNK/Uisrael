package com.uisrael.relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uisrael.relaciones.entities.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
	
}
