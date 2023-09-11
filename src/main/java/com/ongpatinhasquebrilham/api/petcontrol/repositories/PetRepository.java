package com.ongpatinhasquebrilham.api.petcontrol.repositories;

import com.ongpatinhasquebrilham.api.petcontrol.domain.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
