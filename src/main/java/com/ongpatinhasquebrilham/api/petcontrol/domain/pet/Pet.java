package com.ongpatinhasquebrilham.api.petcontrol.domain.pet;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pet {
	//TODO: fix attributes types

/*
** espécie (pré-definido)
** gênero (pré-definido)
** idade estimada (int) [calcular e armazenar como data]
** raça (max 40 caracteres)
** porte (pré-definido)
** peso (max 3 dígitos/99.9kg)
** castrado (boleano)
*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(length = 80, nullable = false)
	private String name;

	private String species;			//ENTIDADE: espécie de animal, criar uma tabela e popular automaticamente
	private String gender;			//enum
	private LocalDate birthdate;	//ajustar mes e ano
	private String breed;
	private String size;			//ENTIDADE: porte: criar uma tabela e popular automaticamente
	private Integer weight;			//peso
	private boolean isNeutered;

	@Pattern(regexp = "[0-9]{15}")
	@Column(length = 15)
	private String microchip;

	@Column(columnDefinition = "TEXT")
	private String vaccination;

	@Column(columnDefinition = "TEXT")
	private String description;

	@CreationTimestamp(source = SourceType.DB)
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	private boolean active;

}