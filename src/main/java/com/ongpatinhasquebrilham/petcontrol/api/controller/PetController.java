package com.ongpatinhasquebrilham.petcontrol.api.controller;

import com.ongpatinhasquebrilham.petcontrol.api.assembler.PetInputModelDisassembler;
import com.ongpatinhasquebrilham.petcontrol.api.assembler.PetModelAssembler;
import com.ongpatinhasquebrilham.petcontrol.api.model.PetModel;
import com.ongpatinhasquebrilham.petcontrol.api.model.PetInputModel;
import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
import com.ongpatinhasquebrilham.petcontrol.domain.repository.PetRepository;
import com.ongpatinhasquebrilham.petcontrol.domain.service.PetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pets")
public class PetController {

	private PetService petService;
	private PetRepository petRepository;
	private PetModelAssembler petModelAssembler;
	private PetInputModelDisassembler petInputModelDisassembler;

	@GetMapping
	public ResponseEntity<List<PetModel>> getPets() {
		List<PetModel> pets = petModelAssembler.toCollectionModel(petRepository.findAll());
		return ResponseEntity.ok(pets);
	}

	@GetMapping("/{petId}")
	public ResponseEntity<PetModel> getPet(@PathVariable Long petId) {
		return petRepository.findById(petId)
				.map(petModelAssembler::toModel)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<PetModel> savePet(@Valid @RequestBody PetInputModel petInputModel) {
		Pet newPet = petService.save(petInputModelDisassembler.toDomainObject(petInputModel));
		PetModel petModel = petModelAssembler.toModel(newPet);

		return ResponseEntity.status(HttpStatus.CREATED).body(petModel);
	}

	@PutMapping("/{petId}")
	public ResponseEntity<PetModel> updatePet(@PathVariable Long petId, @Valid @RequestBody PetInputModel petInputModel) {
		if (!petRepository.existsById(petId)) {
			return ResponseEntity.notFound().build();
		}

		Pet currentPet = petService.find(petId);
		petInputModelDisassembler.copyToDomainObject(petInputModel, currentPet);

		Pet updatedPet = petService.save(currentPet);
		PetModel petModel = petModelAssembler.toModel(updatedPet);

		return ResponseEntity.ok(petModel);
	}

	@DeleteMapping("{petId}")
	public ResponseEntity<Void> deletePet(@PathVariable Long petId) {
		if (!petRepository.existsById(petId)) {
			return ResponseEntity.notFound().build();
		}

		petService.delete(petId);

		return ResponseEntity.noContent().build();
	}

}