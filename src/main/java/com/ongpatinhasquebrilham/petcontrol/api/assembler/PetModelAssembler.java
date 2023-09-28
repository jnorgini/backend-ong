package com.ongpatinhasquebrilham.petcontrol.api.assembler;

import com.ongpatinhasquebrilham.petcontrol.api.model.PetModel;
import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PetModelAssembler {

    private final ModelMapper modelMapper;

    public PetModel toModel(Pet pet) {
        return modelMapper.map(pet, PetModel.class);
    }

    public List<PetModel> toCollectionModel(List<Pet> pets) {
        return pets.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}