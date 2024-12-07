package com.example.JFSD_SDP.controller;

import com.example.JFSD_SDP.dto.AdminLoginRequest;
import com.example.JFSD_SDP.model.Admin;
import com.example.JFSD_SDP.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "*") // Allows requests from any origin
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/checkadminlogin")
    public ResponseEntity<?> checkAdminLogin(@RequestBody AdminLoginRequest loginRequest) {
        Admin admin = adminService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (admin != null) {
            return ResponseEntity.ok(admin); // Return admin details if login is successful
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}
