package com.example.catalog.controller;

import com.example.catalog.customer.*;
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
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerRequestDTO data) {
        Customer customer = new Customer(data);
        repository.save(customer);
        return new ResponseEntity<>(customer, HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerUpdateDTO data) {
        Customer customer = repository.getReferenceById(data.phoneNumber());
        customer.setName(data.name());
        repository.save(customer);
        return new ResponseEntity<>(data.response(), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestParam CustomerDeleteDTO data) {
        Customer customer = repository.getReferenceById(data.phoneNumber());
        repository.delete(customer);
        return new ResponseEntity<>(data.response(), HttpStatusCode.valueOf(200));
    }
}
