package com.example.firstSpring.service;

import com.example.firstSpring.entity.Address;
import com.example.firstSpring.entity.Employee;
import com.example.firstSpring.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        List <Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Optional<Employee> searchEmployeeById(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new RuntimeException("Employee Not Found"));
        return Optional.of(employee);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        ArrayList<Address> addressArrayList = new ArrayList<>();

        for(Address address : employee.getAddress()) {
            addressArrayList.add(new Address(address.getStreet(),
                    address.getCity(),
                    address.getState(),
                    address.getCountry(),
                    address.getPostalCode(),
                    address.getEmployee()));
        }
         return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeDetails(Integer employeeId, Employee employee) {
        Optional <Employee> employeefromDB = employeeRepository.findById(employeeId);
        if (employeefromDB.isEmpty()) {
            return null;
        }
        Employee existingEmployee = employeefromDB.get();
        existingEmployee.setEmployeeName(employee.getEmployeeName());
        existingEmployee.setEmployeeAddress(employee.getEmployeeAddress());
        existingEmployee.setEmployeeSalary(employee.getEmployeeSalary());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public Employee deleteEmployee(Integer employeeId) {

        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
        }
        else {
            throw new RuntimeException("Employee not found for id " + employeeId);
        }
        return employee.get();
    }




}
