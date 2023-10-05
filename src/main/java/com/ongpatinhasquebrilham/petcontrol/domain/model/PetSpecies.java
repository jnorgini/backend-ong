package com.ongpatinhasquebrilham.petcontrol.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PetSpecies {
    DOG("Cão"),
    CAT("Gato");

    private final String species;

    PetSpecies(String species) {
        this.species = species;
    }

    @JsonValue
    public String species() {
        return species;
    }
}