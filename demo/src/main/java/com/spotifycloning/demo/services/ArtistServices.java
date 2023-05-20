package com.spotifycloning.demo.services;

import com.spotifycloning.demo.models.entities.Artist;
import com.spotifycloning.demo.models.repositories.ArtistRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ArtistServices {

    @Autowired
    private ArtistRepositories artistRepositories;

    // Create and Update
    public Artist save(Artist artist) {
        return artistRepositories.save(artist);
    }

    // Find All Data
    public Iterable<Artist> findAll() {
        return artistRepositories.findAll();
    }

    // Find One By ID
    public Artist findOne(Long id) {
        Optional<Artist> artist = artistRepositories.findById(id);
        if(!artist.isPresent()) {
            return null;
        }
        return artist.get();
    }

    // Delete
    public void removeOne(Long id) {
        artistRepositories.deleteById(id);
    }
}
