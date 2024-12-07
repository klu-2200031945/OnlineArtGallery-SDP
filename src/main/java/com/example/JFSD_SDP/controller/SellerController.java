package com.example.JFSD_SDP.controller;

import com.example.JFSD_SDP.dto.CustomerLoginRequest;
import com.example.JFSD_SDP.model.Seller;
import com.example.JFSD_SDP.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
@CrossOrigin(origins = "http://localhost:3000")
public class SellerController {

    private final SellerService service;

    public SellerController(SellerService service) {
        this.service = service;
    }

    @PostMapping("/checksellerlogin")
    public ResponseEntity<?> checkSellerLogin(@RequestBody CustomerLoginRequest loginRequest) {
        // Find seller by email and password
        Seller seller = service.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        
        // If seller is found, return seller details, otherwise return 401 error
        if (seller != null) {
            return ResponseEntity.ok(seller);
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }
    @PostMapping("/addseller")
    public ResponseEntity<String> addSeller(@RequestBody Seller seller) {
        try {
        	service.saveSeller(seller);
            return ResponseEntity.ok("Seller added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding seller: " + e.getMessage());
        }
    }
}
