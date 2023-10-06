package com.ongpatinhasquebrilham.petcontrol.domain.service;

import com.ongpatinhasquebrilham.petcontrol.domain.exception.PetNotFoundException;
import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
import com.ongpatinhasquebrilham.petcontrol.domain.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PetService {

	private PetRepository repository;

	@Transactional
	public Pet save(Pet pet) {
		return repository.save(pet);
	}

	@Transactional
	public void delete(Long petId) {
		repository.deleteById(petId);
	}

	@Transactional
	public void turnAvailable(Long petId) {
		Pet currentPet = find(petId);
		currentPet.turnAvailable();
	}

	@Transactional
	public void turnUnavailable(Long petId) {
		Pet currentPet = find(petId);
		currentPet.turnUnavailable();
	}

	public List<Pet> findAll() {
		return repository.findAll();
	}

	public List<Pet> findAllByAvailable(boolean available) {
		return repository.findAllByAvailable(available);
	}

	public Pet find(Long petId) {
		return repository.findById(petId)
				.orElseThrow(() -> new PetNotFoundException(petId));
	}

}