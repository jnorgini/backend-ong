package com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.entities.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
