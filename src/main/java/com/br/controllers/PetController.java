package com.br.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.dto.PetDTO;
import com.br.entities.Pet;
import com.br.services.PetService;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "*")
public class PetController {

	@Autowired
	private PetService service;

	@GetMapping("/all")
	public ResponseEntity<List<Pet>> findAll() {
		List<Pet> pets = service.findAll();
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PetDTO> findById(@PathVariable Long id) {
		PetDTO obj = service.findById(id);
		return new ResponseEntity<>(obj, HttpStatus.OK);
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
