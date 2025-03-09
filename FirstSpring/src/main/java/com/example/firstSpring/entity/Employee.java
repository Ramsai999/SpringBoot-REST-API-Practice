package com.example.firstSpring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @NotBlank
    private String employeeName;

    @NotBlank
    private String employeeAddress;

    @NotNull
    private double employeeSalary;

    @OneToOne
    @JoinColumn(name="salary_account_id")
    private SalaryAcc salaryAccount;

    @OneToMany(mappedBy = "employee")
    private List<Address> address;

    @ManyToMany(mappedBy = "employee")
    private List<Projects> projects;

    public void removeProject(Projects project) {
        this.projects.remove(project);
        project.getEmployee().remove(project);
    }

    public void addProject(Projects project) {
        this.projects.add(project);
        project.getEmployee().add(this);
    }




}
