package com.uisrael.relaciones.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Nombre;
	private String Ruc;
	@OneToMany(mappedBy= "empresa",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	private List<Departamentos> departamentos= new ArrayList<>();
}
