package com.ongpatinhasquebrilham.petcontrol.api.controller;

import com.ongpatinhasquebrilham.petcontrol.api.assembler.PetInputModelDisassembler;
import com.ongpatinhasquebrilham.petcontrol.api.assembler.PetModelAssembler;
import com.ongpatinhasquebrilham.petcontrol.api.model.PetInputModel;
import com.ongpatinhasquebrilham.petcontrol.api.model.PetModel;
import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
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
	private PetModelAssembler petModelAssembler;
	private PetInputModelDisassembler petInputModelDisassembler;

	@GetMapping
	public ResponseEntity<List<PetModel>> getAvailablePets() {
		List<Pet> pets = petService.findAllByAvailable(true);
		return ResponseEntity.ok(petModelAssembler.toCollectionModel(pets));
	}

	@PostMapping
	public ResponseEntity<PetModel> savePet(@Valid @RequestBody PetInputModel petInputModel) {
		Pet newPet = petService.save(petInputModelDisassembler.toDomainObject(petInputModel));
		return ResponseEntity.status(HttpStatus.CREATED).body(petModelAssembler.toModel(newPet));
	}

	@GetMapping("/unavailable")
	public ResponseEntity<List<PetModel>> getUnavailablePets() {
		List<Pet> pets = petService.findAllByAvailable(false);
		return ResponseEntity.ok(petModelAssembler.toCollectionModel(pets));
	}

	@GetMapping("/{petId}")
	public ResponseEntity<PetModel> getPet(@PathVariable Long petId) {
		Pet currentPet = petService.find(petId);
		return ResponseEntity.ok(petModelAssembler.toModel(currentPet));
	}

	@PutMapping("/{petId}")
	public ResponseEntity<PetModel> updatePet(@PathVariable Long petId, @Valid @RequestBody PetInputModel petInputModel) {
		Pet currentPet = petService.find(petId);
		petInputModelDisassembler.copyToDomainObject(petInputModel, currentPet);

		Pet updatedPet = petService.save(currentPet);
		return ResponseEntity.ok(petModelAssembler.toModel(updatedPet));
	}

	@DeleteMapping("/{petId}")
	public ResponseEntity<Void> deletePet(@PathVariable Long petId) {
		petService.delete(petId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{petId}/available")
	public ResponseEntity<Void> turnAvailable(@PathVariable Long petId) {
		petService.turnAvailable(petId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{petId}/available")
	public ResponseEntity<Void> turnUnavailable(@PathVariable Long petId) {
		petService.turnUnavailable(petId);
		return ResponseEntity.noContent().build();
	}

}