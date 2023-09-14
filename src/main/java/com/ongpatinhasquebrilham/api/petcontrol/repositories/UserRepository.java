package com.ongpatinhasquebrilham.api.petcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.ongpatinhasquebrilham.api.petcontrol.domain.user.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
	UserDetails findByUsername(String username);
}
