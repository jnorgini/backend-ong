package com.ongpatinhasquebrilham.application.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pet {
	//TODO: fix attributes types

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String species;
	private String gender;
	private LocalDate birthdate;
	private String breed;
	private String size;
	private Integer weight;
	private boolean isNeutered;
	private boolean isVaccinated;

	@Column(columnDefinition = "TEXT")
	private String description;

}