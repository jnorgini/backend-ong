package com.ongpatinhasquebrilham.petcontrol.domain.service;

import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
import com.ongpatinhasquebrilham.petcontrol.domain.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {

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
	public Pet findById(Long id) {
		return repo.findById(id).orElse(null);
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