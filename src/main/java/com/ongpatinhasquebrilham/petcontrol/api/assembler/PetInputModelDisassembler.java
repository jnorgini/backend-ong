package com.ongpatinhasquebrilham.petcontrol.api.assembler;

import com.ongpatinhasquebrilham.petcontrol.api.model.PetInputModel;
import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PetInputModelDisassembler {

    private final ModelMapper modelMapper;

    public Pet toDomainObject(PetInputModel petInputModel) {
        return modelMapper.map(petInputModel, Pet.class);
    }

    public void copyToDomainObject(PetInputModel petInputModel, Pet pet) {
        modelMapper.map(petInputModel, pet);
    }

}