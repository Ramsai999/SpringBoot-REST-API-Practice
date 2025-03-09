package com.example.firstSpring.service;

import com.example.firstSpring.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<Employee> getAllEmployees();


    Optional<Employee> searchEmployeeById(Integer employeeId);


    Employee deleteEmployee(Integer employeeId);


    Employee createEmployee(Employee employee);

    Employee updateEmployeeDetails(Integer employeeId, Employee employee);
}
