package com.project.tasks.domain.entities;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @ManyToOne
    private Project assignedProject;

}
