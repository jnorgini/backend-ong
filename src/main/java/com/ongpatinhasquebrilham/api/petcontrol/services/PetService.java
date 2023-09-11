package com.ongpatinhasquebrilham.api.petcontrol.services;

import com.ongpatinhasquebrilham.api.petcontrol.domain.pet.Pet;

import java.util.List;

public interface PetService {

	List<Pet> findAll();
	Pet add(Pet obj);
	Pet findById(Long id);
	Pet update(Pet obj);
	void remove(Long id);

}
