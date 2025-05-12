package com.project.tasks.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class Project {

    private UUID id;

    private String name;

    @OneToMany(mappedBy = "project")
    private List<TaskList> taskLists;

    @OneToMany(mappedBy = "assignedProject")
    private List<User> users;

}
