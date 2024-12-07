package com.example.JFSD_SDP.controller;

import com.example.JFSD_SDP.model.Art;
import com.example.JFSD_SDP.service.ArtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/art")
@CrossOrigin(origins = "http://localhost:3000")
public class ArtController {

    private final ArtService artService;

    public ArtController(ArtService artService) {
        this.artService = artService;
    }

    @PostMapping("/addart")
    public ResponseEntity<String> addArt(@RequestParam("category") String category,
                                         @RequestParam("title") String title,
                                         @RequestParam("description") String description,
                                         @RequestParam("price") String price,
                                         @RequestParam("file") MultipartFile file) {

        try {
            // Convert price from String to BigDecimal
            BigDecimal artPrice = new BigDecimal(price);

            // Convert file to byte array
            byte[] fileBytes = file.getBytes();

            // Create an Art object
            Art art = new Art(category, title, description, artPrice, fileBytes);

            // Save the Art object to the database
            artService.saveArt(art);

            return ResponseEntity.ok("Art added successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error while uploading the art: " + e.getMessage());
        }
    }
    @GetMapping("/viewarts")
    public ResponseEntity<List<Art>> getAllArts() {
        List<Art> arts = artService.getAllArts();
        return ResponseEntity.ok(arts); // Return the list of arts
    }
}
