package com.uisrael.relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uisrael.relaciones.entities.Departamentos;

@Repository
public interface DepartamentosRepository extends JpaRepository<Departamentos, Long>{

}
