package com.ongpatinhasquebrilham.application.controllers;

import com.ongpatinhasquebrilham.application.entities.Pet;
import com.ongpatinhasquebrilham.application.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class PetController {

	private PetService service;

	@GetMapping("/all")
	public ResponseEntity<List<Pet>> findAll() {
		List<Pet> pets = service.findAll();
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pet> findById(@PathVariable Long id) {
		Pet pet = service.findById(id);
		return new ResponseEntity<>(pet, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Pet> add(@RequestBody Pet obj) {
		Pet newPet = service.add(obj);
		return new ResponseEntity<>(newPet, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Pet> update(@RequestBody Pet obj) {
		Pet updatePet = service.update(obj);
		return new ResponseEntity<>(updatePet, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public void remove(@PathVariable Long id) {
		service.remove(id);
	}

}