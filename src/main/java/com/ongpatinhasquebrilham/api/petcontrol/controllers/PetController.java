package com.ongpatinhasquebrilham.api.petcontrol.controllers;

import com.ongpatinhasquebrilham.api.petcontrol.domain.pet.Pet;
import com.ongpatinhasquebrilham.api.petcontrol.services.PetService;
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
	/*
	GET    /pets       -> Retorna uma lista de pets
	GET    /pets/{id}  -> Retorna o pet através do id
	POST   /pets       -> Cria um pet
	PUT    /pets/{id}  -> Atualiza o pet através do id
	PATCH  /pets/{id}  -> Atualiza parcialmente o pet através do id
	DELETE /pets/{id}  -> Remove o pet através do id
	 */

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
	public ResponseEntity<Pet> update(@RequestBody Pet obj) {
		Pet updatePet = service.update(obj);
		return new ResponseEntity<>(updatePet, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public void remove(@PathVariable Long id) {
		service.remove(id);
	}

}