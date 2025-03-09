package com.example.firstSpring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SalaryAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private String accountName;

    @OneToOne(mappedBy = "salaryAccount")
    @JoinColumn(name="employee_id")
    private Employee employee;


}
