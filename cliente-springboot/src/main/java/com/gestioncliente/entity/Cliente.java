package com.gestioncliente.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ci;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String email;
}
