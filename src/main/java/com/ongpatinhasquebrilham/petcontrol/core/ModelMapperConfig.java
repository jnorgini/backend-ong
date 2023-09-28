package com.ongpatinhasquebrilham.petcontrol.core;

import com.ongpatinhasquebrilham.petcontrol.api.model.PetInputModel;
import com.ongpatinhasquebrilham.petcontrol.api.model.PetModel;
import com.ongpatinhasquebrilham.petcontrol.domain.model.Pet;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<Integer, LocalDate> toEstimatedBirthdate =
                ctx -> LocalDate.now().minusMonths(ctx.getSource());

        Converter<LocalDate, Integer> toAgeInMonths =
                ctx -> Long.valueOf(
                        ChronoUnit.MONTHS.between(
                                ctx.getSource(),
                                LocalDate.now()))
                        .intValue();

        modelMapper.createTypeMap(PetInputModel.class, Pet.class)
                .addMappings(mapper -> mapper.using(toEstimatedBirthdate)
                        .map(PetInputModel::getAgeInMonths, Pet::setBirthdate));

        modelMapper.createTypeMap(Pet.class, PetModel.class)
                .addMappings(mapper -> mapper.using(toAgeInMonths)
                        .map(Pet::getBirthdate, PetModel::setAgeInMonths));

        return modelMapper;
    }
    
}