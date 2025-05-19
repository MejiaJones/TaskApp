package com.project.tasks.services.impl;

import com.project.tasks.domain.dto.AuthRequest;
import com.project.tasks.domain.dto.AuthResponse;
import com.project.tasks.domain.entities.User;
import com.project.tasks.repositories.UserRepository;
import com.project.tasks.security.JwtUtil;
import com.project.tasks.security.UserPrincipal;
import com.project.tasks.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        // Autentica el usuario con Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Extrae el usuario autenticado
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        // Genera el token JWT PASANDO UserPrincipal que es UserDetails
        String token = jwtUtil.generateToken(userPrincipal);

        // Devuelve el token en la respuesta
        return new AuthResponse(token);
    }
}
