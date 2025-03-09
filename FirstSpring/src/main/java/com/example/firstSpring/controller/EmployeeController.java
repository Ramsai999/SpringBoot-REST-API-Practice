package com.example.firstSpring.controller;


import com.example.firstSpring.entity.Employee;
import com.example.firstSpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer employeeId) {
        Optional<Employee> employee = employeeService.searchEmployeeById(employeeId);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>( createdEmployee, HttpStatus.CREATED);

    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployeeDetails(employeeId, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer employeeId) {
        try {
            Employee deletedEmployee = employeeService.deleteEmployee(employeeId);
            return new ResponseEntity<>(deletedEmployee, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
