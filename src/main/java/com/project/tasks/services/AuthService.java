package com.project.tasks.services;

import com.project.tasks.domain.dto.AuthRequest;
import com.project.tasks.domain.dto.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    AuthResponse login(AuthRequest request);
}
