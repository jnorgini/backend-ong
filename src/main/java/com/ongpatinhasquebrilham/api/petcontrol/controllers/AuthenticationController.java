package com.ongpatinhasquebrilham.api.petcontrol.controllers;

import com.ongpatinhasquebrilham.api.petcontrol.domain.user.AuthenticationDTO;
import com.ongpatinhasquebrilham.api.petcontrol.domain.user.LoginResponseDTO;
import com.ongpatinhasquebrilham.api.petcontrol.domain.user.RegisterDTO;
import com.ongpatinhasquebrilham.api.petcontrol.domain.user.User;
import com.ongpatinhasquebrilham.api.petcontrol.infrastructure.security.TokenService;
import com.ongpatinhasquebrilham.api.petcontrol.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private UserRepository repository;
    private TokenService tokenService;

    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (!Objects.isNull(this.repository.findByUsername(data.username()))) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}