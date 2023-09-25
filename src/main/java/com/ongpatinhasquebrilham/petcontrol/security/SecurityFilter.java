package com.ongpatinhasquebrilham.petcontrol.security;

import java.io.IOException;
import java.util.Objects;

import jakarta.annotation.Nonnull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ongpatinhasquebrilham.petcontrol.domain.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoveryToken(request);

        if (!Objects.isNull(token)) {
            var username = tokenService.validateToken(token);
            UserDetails userDetails = userRepository.findByUsername(username);

            var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (Objects.isNull(authHeader)) {
            return null;
        }

        return authHeader.replace("Bearer ", "");

    }
}
