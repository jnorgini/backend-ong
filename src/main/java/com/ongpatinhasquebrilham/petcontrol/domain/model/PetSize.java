package com.ongpatinhasquebrilham.petcontrol.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PetSize {
    SMALL("Pequeno"),
    MEDIUM("Médio"),
    LARGE("Grande");

    private final String size;

    PetSize(String size) {
        this.size = size;
    }

    @JsonValue
    public String size() {
        return size;
    }
}