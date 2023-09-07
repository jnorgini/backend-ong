package com.br.services;

import java.util.List;

import com.br.dto.DogDTO;
import com.br.entities.Dog;

public interface ServiceDog {

	public List<Dog> findAll();

	public Dog add(Dog obj);

	public DogDTO findById(Long id);

	public Dog update(Dog obj);

	public void remove(Long id);

}
