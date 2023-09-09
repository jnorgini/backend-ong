package com.ongpatinhasquebrilham.application.repositories;

import com.ongpatinhasquebrilham.application.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
