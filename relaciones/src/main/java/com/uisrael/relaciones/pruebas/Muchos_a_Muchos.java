package com.uisrael.relaciones.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.uisrael.relaciones.entities.Asignatura;
import com.uisrael.relaciones.entities.Estudiante;
import com.uisrael.relaciones.repositories.AsignaturaRepository;
import com.uisrael.relaciones.repositories.EstudianteRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class Muchos_a_Muchos implements CommandLineRunner{

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	@Autowired
	private EstudianteRepository estudianteRepository;
	public void run(String... args) throws Exception {
		Estudiante estudiante1= new Estudiante();
		estudiante1.setNombre("Jhonatan");
		Estudiante estudiante2= new Estudiante();
		estudiante2.setNombre("Alejandro");
		Asignatura asignatura1= new Asignatura();
		asignatura1.setNombre("Desarrollo de Software II");
		Asignatura asignatura2= new Asignatura();
		asignatura2.setNombre("Redes II");
		estudiante1.getAsignaturas().add(asignatura1);
		estudiante2.getAsignaturas().add(asignatura1);
		estudiante2.getAsignaturas().add(asignatura2);
		
		estudianteRepository.save(estudiante1);

		estudianteRepository.save(estudiante2);
		
		Estudiante estudianteRecuperado = estudianteRepository.findById(2L).orElse(null);
		System.out.println("Estudiante: "+estudianteRecuperado.getNombre());
		
		Asignatura asignaturaRecuperada = asignaturaRepository.findById(2L).orElse(null);
		System.out.println("Asignatura: "+asignaturaRecuperada.getNombre());
		
		estudianteRepository.deleteById(1L);
		asignaturaRepository.deleteById(1L);
	}
}
