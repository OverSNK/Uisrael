package com.uisrael.relaciones.pruebas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.relaciones.entities.Motor;
import com.uisrael.relaciones.repositories.MotorRepository;

public class JPQL {
	@Autowired
    private MotorRepository motorRepository;

    public List<Motor> encontrarMotoresPorCilindrada(String cc) {
        return motorRepository.findByCcLike(cc);
    }

    public void mostrarResultadosEnConsola() {
        List<Motor> motores = encontrarMotoresPorCilindrada("4.0L");
        for (Motor motor : motores) {
            System.out.println("Marca: " + motor.getMarca());
            System.out.println("Cilindrada: " + motor.getCC());
        }
    }
}
