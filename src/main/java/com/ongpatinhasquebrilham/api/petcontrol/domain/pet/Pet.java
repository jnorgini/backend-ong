package com.ongpatinhasquebrilham.api.petcontrol.domain.pet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
	private String age;
	private String breed;
	private String size;
	private Integer weight;
	private boolean isNeutered;
	private boolean isVaccinated;

	@Column(columnDefinition = "TEXT")
	private String description;

}