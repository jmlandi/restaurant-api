package com.example.catalog.controller;

import com.example.catalog.customer.Customer;
import com.example.catalog.customer.CustomerRepository;
import com.example.catalog.customer.CustomerRequestDTO;
import com.example.catalog.customer.CustomerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public List<CustomerResponseDTO> getAll() {
        return repository.findAll().stream().map(CustomerResponseDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerRequestDTO data) {
        Customer customer = new Customer(data);
        repository.save(customer);
        return new ResponseEntity<>("Created with phone number: " + data.phoneNumber(), HttpStatusCode.valueOf(201));
    }

}
