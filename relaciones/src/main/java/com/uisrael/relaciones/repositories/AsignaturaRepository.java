package com.uisrael.relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uisrael.relaciones.entities.Asignatura;
@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{

}
