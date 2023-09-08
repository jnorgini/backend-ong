package com.br.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dto.PetDTO;
import com.br.entities.Pet;
import com.br.repositories.PetRepository;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository repo;

	@Override
	public List<Pet> findAll() {
		return repo.findAll();
	}

	@Override
	public Pet add(Pet obj) {
		return repo.save(obj);
	}

	@Transactional(readOnly = true)
	public PetDTO findById(Long id) {
		Pet obj = repo.findById(id).get();
		return new PetDTO(obj);
	}

	@Override
	public Pet update(Pet obj) {
		return repo.save(obj);
	}

	@Override
	public void remove(Long id) {
		repo.deleteById(id);

	}

}
