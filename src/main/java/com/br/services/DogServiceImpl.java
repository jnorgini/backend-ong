package com.br.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dto.DogDTO;
import com.br.entities.Dog;
import com.br.repositories.DogRepository;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogRepository repo;

	@Override
	public List<Dog> findAll() {
		return repo.findAll();
	}

	@Override
	public Dog add(Dog obj) {
		return repo.save(obj);
	}

	@Transactional(readOnly = true)
	public DogDTO findById(Long id) {
		Dog obj = repo.findById(id).get();
		return new DogDTO(obj);
	}

	@Override
	public Dog update(Dog obj) {
		return repo.save(obj);
	}

	@Override
	public void remove(Long id) {
		repo.deleteById(id);

	}

}
