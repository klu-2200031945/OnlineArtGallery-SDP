package com.example.JFSD_SDP.service;

import com.example.JFSD_SDP.model.Customer;
import com.example.JFSD_SDP.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }
    public Customer findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
}