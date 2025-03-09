package com.example.firstSpring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String projectTitle;
    private String clientName;
    private String projectDescription;

    public Projects(String clientName, String projectTitle) {
        this.clientName = clientName;
        this.projectTitle = projectTitle;
    }

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "project_employee",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name="employee_id")
    )

    private List<Employee> employee;






}
