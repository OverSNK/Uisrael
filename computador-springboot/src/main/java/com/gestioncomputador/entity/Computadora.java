package com.gestioncomputador.entity;
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
@Table(name = "tbl_computador")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Computadora {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String procesador;
private String ram;
private String discoDuro;
}
