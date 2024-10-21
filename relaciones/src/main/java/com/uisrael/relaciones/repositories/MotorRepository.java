package com.uisrael.relaciones.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.relaciones.entities.Motor;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Long>{
	@Query("SELECT m FROM Motor m WHERE m.cc LIKE '4.0L'")
    List<Motor> findByCcLike(String cc);

    @Query("SELECT m FROM Motor m JOIN m.marca marca WHERE marca.nombre = 'Toyota'")
    List<Motor> findByMarcaNombre(String nombreMarca);

    @Query("SELECT m FROM Motor m WHERE m.cc = (SELECT MAX(m2.cc) FROM Motor m2)")
    Motor findMotorConMayorCilindrada();

    @Query("SELECT COUNT(m) FROM Motor m WHERE m.cc LIKE '6.0L'")
    Long contarMotoresDeSeisCilindros();
    
    @Query("SELECT m FROM Motor m JOIN m.marca marca WHERE marca.nombre = 'Toyota' AND m.cc > 2.0L")
    List<Motor> findByMarcaAndCcGreaterThanOrderByPotenciaDesc(String marca);
}