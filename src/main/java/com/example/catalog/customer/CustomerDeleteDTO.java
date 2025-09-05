package com.example.catalog.customer;

public record CustomerDeleteDTO(String phoneNumber) {

    public String response() {
        return "User deleted. Phone number: " + this.phoneNumber();
    }

}
