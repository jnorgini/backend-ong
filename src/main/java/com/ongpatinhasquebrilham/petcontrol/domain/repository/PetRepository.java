package com.ongpatinhasquebrilham.petcontrol.domain.repository;

import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}