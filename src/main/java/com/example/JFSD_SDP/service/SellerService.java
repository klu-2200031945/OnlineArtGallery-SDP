package com.example.JFSD_SDP.service;

import com.example.JFSD_SDP.repository.SellerRepository;
import com.example.JFSD_SDP.model.Customer;
import com.example.JFSD_SDP.model.Seller;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private final SellerRepository repository;

    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    public Seller findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
    public Seller saveSeller(Seller seller) {
        return repository.save(seller);
    }
}
