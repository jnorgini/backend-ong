package com.ongpatinhasquebrilham.petcontrol.domain.exception;

public class PetNotFoundException extends EntityNotFoundException {

    public PetNotFoundException(String message) {
        super(message);
    }

    public PetNotFoundException(Long petId) {
        this(String.format("Não existe um cadastro de pet com código %d", petId));
    }
}
