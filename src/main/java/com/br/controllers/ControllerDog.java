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

import com.br.dto.DogDTO;
import com.br.entities.Dog;
import com.br.services.ServiceDog;

@RestController
@RequestMapping("/dogs")
@CrossOrigin(origins = "*")
public class ControllerDog {

	@Autowired
	private ServiceDog service;

	@GetMapping("/all")
	public ResponseEntity<List<Dog>> findAll() {
		List<Dog> dogs = service.findAll();
		return new ResponseEntity<>(dogs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DogDTO> findById(@PathVariable Long id) {
		DogDTO obj = service.findById(id);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Dog> add(@RequestBody Dog obj) {
		Dog newDog = service.add(obj);
		return new ResponseEntity<>(newDog, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Dog> update(@RequestBody Dog obj) {
		Dog updateDog = service.update(obj);
		return new ResponseEntity<>(updateDog, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		service.remove(id);
		return new ResponseEntity<>("Cadastro removido com sucesso!", HttpStatus.ACCEPTED);
	}

}
