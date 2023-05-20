package com.spotifycloning.demo.services;

import com.spotifycloning.demo.models.entities.Album;
import com.spotifycloning.demo.models.repositories.AlbumRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class AlbumServices {

    @Autowired
    private AlbumRepositories albumRepositories;

    // Create and Update
    public Album save(Album album) {
        return albumRepositories.save(album);
    }

    // Find All Data
    public Iterable<Album> findALl() {
        return albumRepositories.findAll();
    }

    // Find One By ID
    public Album findOne(Long id) {
        Optional<Album> album = albumRepositories.findById(id);
        if(!album.isPresent()) {
            return null;
        }

        return album.get();
    }

    // Delete
    public void removeOne(Long id) {
        albumRepositories.deleteById(id);
    }
}
