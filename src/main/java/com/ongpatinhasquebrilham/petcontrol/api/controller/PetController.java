package com.ongpatinhasquebrilham.petcontrol.api.controller;

import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
import com.ongpatinhasquebrilham.petcontrol.domain.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@AllArgsConstructor
public class PetController {

	private PetService service;

	@GetMapping
	public ResponseEntity<List<Pet>> findAll() {
		List<Pet> pets = service.findAll();
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pet> findById(@PathVariable Long id) {
		Pet pet = service.findById(id);
		return new ResponseEntity<>(pet, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Pet> add(@RequestBody Pet obj) {
		Pet newPet = service.add(obj);
		return new ResponseEntity<>(newPet, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pet> update(@PathVariable Long id, @RequestBody Pet obj) {
		obj.setId(id);
		Pet updatePet = service.update(obj);
		return new ResponseEntity<>(updatePet, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public void remove(@PathVariable Long id) {
		service.remove(id);
	}

}