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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Column(length = 80, nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PetSpecies species;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PetGender gender;

	@Column(nullable = false)
	private LocalDate birthdate;

	@Column(nullable = false)
	private String breed;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PetSize size;

	@Column(nullable = false)
	private double weight;

	@Pattern(regexp = "[0-9]{15}")
	@Column(length = 15)
	private String microchip;

	@Column(nullable = false)
	private boolean isNeutered;

	@Column(columnDefinition = "TEXT")
	private String vaccination;

	@Column(columnDefinition = "TEXT")
	private String description;

	@CreationTimestamp(source = SourceType.DB)
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private boolean available = true;

	public void turnAvailable() {
		setAvailable(true);
	}
	public void turnUnavailable() {
		setAvailable(false);
	}

}