package com.example.catalog.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name="customers")
@Entity(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer {
    @Id
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public Customer(CustomerRequestDTO data) {
        this.phoneNumber = data.phoneNumber();
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.dateOfBirth = data.dateOfBirth();
    }
}
