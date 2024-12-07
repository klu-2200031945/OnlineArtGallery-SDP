package com.example.JFSD_SDP.service;

import com.example.JFSD_SDP.model.Art;
import com.example.JFSD_SDP.repository.ArtRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ArtService {

    private final ArtRepository artRepository;

    public ArtService(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }

    public Art saveArt(Art art) {
        return artRepository.save(art);
    }

    public Optional<Art> getArtById(Long id) {
        return artRepository.findById(id);
    }
    public List<Art> getAllArts() {
        return artRepository.findAll(); // Fetch all arts from the database
    }
}
