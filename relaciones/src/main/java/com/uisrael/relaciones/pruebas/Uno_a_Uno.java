package com.uisrael.relaciones.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uisrael.relaciones.entities.Auto;
import com.uisrael.relaciones.entities.Motor;
import com.uisrael.relaciones.repositories.AutoRepository;
import com.uisrael.relaciones.repositories.MotorRepository;

@Component
public class Uno_a_Uno implements CommandLineRunner{
	@Autowired
	private AutoRepository autoRepository;
	@Autowired
	private MotorRepository motorRepository;
	@Override
	public void run(String...args)throws Exception{
		Motor motor = new Motor();
		motor.setMarca("2JZ-GTE");
		motor.setCC("3.0L");
		motor.setDescripcion("Motor de 6 cilindros en línea, turboalimentado. Utilizado en el Toyota Supra Mk4.");
		
		motorRepository.save(motor);
		
		Auto auto = new Auto();
		auto.setMarca("Toyota");
		auto.setMotor(motor);
		
		autoRepository.save(auto);
	}
}