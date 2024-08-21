package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId((long) (customers.size() + 1));
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> registerCustomer(@RequestParam String name, @RequestParam String email) {
        Customer customer = new Customer();
        customer.setId((long) (customers.size() + 1));
        customer.setName(name);
        customer.setEmail(email);
        customers.add(customer);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(name);
        customerDTO.setEmail(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO);
    }
}
