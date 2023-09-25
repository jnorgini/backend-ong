package com.ongpatinhasquebrilham.petcontrol.api.dto;

import com.ongpatinhasquebrilham.petcontrol.domain.model.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
}
