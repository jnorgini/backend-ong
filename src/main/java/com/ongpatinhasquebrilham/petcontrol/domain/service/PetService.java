package com.ongpatinhasquebrilham.petcontrol.domain.service;

import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;

import java.util.List;

public interface PetService {

	List<Pet> findAll();
	Pet add(Pet obj);
	Pet findById(Long id);
	Pet update(Pet obj);
	void remove(Long id);

}
