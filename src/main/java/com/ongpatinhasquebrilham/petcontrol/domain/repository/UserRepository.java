package com.ongpatinhasquebrilham.petcontrol.domain.repository;

import com.ongpatinhasquebrilham.petcontrol.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
	UserDetails findByUsername(String username);
}