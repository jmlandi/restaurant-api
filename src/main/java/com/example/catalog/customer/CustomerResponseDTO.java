package com.example.catalog.customer;

import java.util.Date;

public record CustomerResponseDTO(String phoneNumber, String name) {
    public CustomerResponseDTO(Customer customer) {
        this(customer.getPhoneNumber(), customer.getName());
    }
}
