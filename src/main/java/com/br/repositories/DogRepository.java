package com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.entities.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

}
