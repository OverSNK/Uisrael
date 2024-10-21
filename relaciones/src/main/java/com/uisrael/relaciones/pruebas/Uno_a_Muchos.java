package com.uisrael.relaciones.pruebas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uisrael.relaciones.entities.Departamentos;
import com.uisrael.relaciones.entities.Empresa;
import com.uisrael.relaciones.repositories.DepartamentosRepository;
import com.uisrael.relaciones.repositories.EmpresaRepository;

@Component
public class Uno_a_Muchos implements CommandLineRunner{
	@Autowired
	private DepartamentosRepository departamentosRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Override
	public void run(String... args) throws Exception {
		Empresa empresa =new Empresa();
		empresa.setNombre("Ecuador.SA");
		empresa.setRuc("1728394728001");
		empresaRepository.save(empresa);
		
		Departamentos departamento1 = new Departamentos();
		departamento1.setNombre("RRHH");
		Departamentos departamento2 = new Departamentos();
		departamento2.setNombre("Informática");
		departamentosRepository.save(departamento1);
		departamentosRepository.save(departamento2);
		
		
		Optional<Empresa> empresaGuardada = empresaRepository.findById(empresa.getId());
		empresaGuardada.ifPresent(e ->{
			System.out.println("Nombre de Empresa: "+e.getNombre());
			e.setNombre("NuevoEcuador.SA:");
			empresaRepository.save(e);
			System.out.println("Empresa Actualizada: "+e.getNombre());
		});
		List<Empresa> empresas = empresaRepository.findAll();
		System.out.println("Lista de Empresas: ");
		for(Empresa e:empresas) {
			System.out.println("-"+e.getNombre());
		}
		empresaRepository.delete(empresa);
		System.out.println("Empresa eliminada");
	}

}
