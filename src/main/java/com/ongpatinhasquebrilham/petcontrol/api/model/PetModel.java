package com.ongpatinhasquebrilham.petcontrol.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetModel {
    private Long id;
    private String name;
    private String species;
    private String gender;
    private Integer ageInMonths;
    private String breed;
    private String size;
    private double weight;
    private String microchip;
    private boolean isNeutered;
    private String vaccination;
    private String description;
}