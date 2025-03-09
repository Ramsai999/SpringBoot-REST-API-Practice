package com.example.firstSpring.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AddressId;
    private String Street;
    private String City;
    private String State;
    private String Country;
    private String PostalCode;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Address(String street, String city, String state, String country, String postalCode, Employee employee) {
        this.Street = street;
        this.City = city;
        this.State = state;
        this.Country = country;
        this.PostalCode = postalCode;
        this.employee = employee;

    }
}
