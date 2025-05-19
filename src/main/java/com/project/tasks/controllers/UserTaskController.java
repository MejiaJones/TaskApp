package com.project.tasks.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserTaskController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/tasks")
    public ResponseEntity<?> getMyTasks() {
        // Solo los usuarios normales
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/projects")
    public ResponseEntity<?> getProjects() {
        // Ambos roles pueden acceder
        return ResponseEntity.ok().build();
    }

}
