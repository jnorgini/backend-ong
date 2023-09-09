package com.ongpatinhasquebrilham.application.services;

import com.ongpatinhasquebrilham.application.entities.Pet;

import java.util.List;

public interface PetService {

	List<Pet> findAll();
	Pet add(Pet obj);
	Pet findById(Long id);
	Pet update(Pet obj);
	void remove(Long id);

}
