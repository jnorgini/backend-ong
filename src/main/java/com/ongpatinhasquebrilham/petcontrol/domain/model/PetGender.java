package com.ongpatinhasquebrilham.petcontrol.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PetGender {
    MALE("Macho"),
    FEMALE("Fêmea");

    private final String gender;

    PetGender(String gender) {
        this.gender = gender;
    }

    @JsonValue
    public String gender() {
        return gender;
    }
}