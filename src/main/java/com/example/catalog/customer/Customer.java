package com.example.catalog.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name="customers")
@Entity(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer {
    @Id
    private String phoneNumber;
    @Setter
    private String name;

    public Customer(CustomerRequestDTO data) {
        this.phoneNumber = data.phoneNumber();
        this.name = data.name();
    }
}
