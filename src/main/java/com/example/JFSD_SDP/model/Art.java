package com.example.JFSD_SDP.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "art")
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String title;
    private String description;
    private BigDecimal price;

    @Lob
    private byte[] file; // Store the uploaded file as a byte array

    public Art() {
    }

    public Art(String category, String title, String description, BigDecimal price, byte[] file) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.file = file;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
