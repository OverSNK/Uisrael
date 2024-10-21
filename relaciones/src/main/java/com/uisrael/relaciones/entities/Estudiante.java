package com.uisrael.relaciones.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name = "estudiante_asignatura",
			joinColumns = @JoinColumn(name = "estudiante_id"),
			inverseJoinColumns = @JoinColumn(name = "asignatura_id")
			)
	private Set<Asignatura> asignaturas = new HashSet<>();
}
