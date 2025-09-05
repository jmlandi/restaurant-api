package com.example.catalog.customer;

public record CustomerUpdateDTO(String phoneNumber, String name) {

    public String response() {
        return "User updated. New name: " + this.name();
    }

}
