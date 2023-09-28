package com.ongpatinhasquebrilham.petcontrol.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pet {

	//TODO: fix attributes types
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