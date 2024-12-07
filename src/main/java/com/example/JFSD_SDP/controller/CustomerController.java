package com.example.JFSD_SDP.controller;

import com.example.JFSD_SDP.dto.CustomerLoginRequest;
import com.example.JFSD_SDP.model.Customer;
import com.example.JFSD_SDP.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*") // Allows requests from any origin
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        service.saveCustomer(customer);
        return ResponseEntity.ok("Customer registered successfully!");
    }
    @PostMapping("/checkcustomerlogin")
    public ResponseEntity<?> checkCustomerLogin(@RequestBody CustomerLoginRequest loginRequest) {
        Customer customer = service.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (customer != null) {
            return ResponseEntity.ok(customer); // Return customer details if login is successful
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }
}
