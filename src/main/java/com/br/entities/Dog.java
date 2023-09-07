package com.br.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dog")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String especie;
	private String genero;
	private String idade;
	private String raca;
	private String porte;
	private String peso;

	@Column(name = "descricao_pet", columnDefinition = "TEXT")
	private String descricaoPet;
	@Column(name = "castrado", columnDefinition = "BOOLEAN")
	private boolean castrado;
	@Column(name = "vacinado", columnDefinition = "BOOLEAN")
	private boolean vacinado;

}
