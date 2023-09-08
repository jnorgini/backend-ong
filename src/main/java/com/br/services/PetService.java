package com.br.services;

import java.util.List;

import com.br.dto.PetDTO;
import com.br.entities.Pet;

public interface PetService {

	public List<Pet> findAll();

	public Pet add(Pet obj);

	public PetDTO findById(Long id);

	public Pet update(Pet obj);

	public void remove(Long id);

}
