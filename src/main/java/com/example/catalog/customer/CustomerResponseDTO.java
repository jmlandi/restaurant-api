package com.example.catalog.customer;

import java.util.Date;

public record CustomerResponseDTO(String phoneNumber, String firstName, String lastName, Date dateOfBirth) {
    public CustomerResponseDTO(Customer customer) {
        this(customer.getPhoneNumber(), customer.getFirstName(), customer.getLastName(), customer.getDateOfBirth());
    }
}
