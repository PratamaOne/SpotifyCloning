package com.spotifycloning.demo.models.repositories;

import com.spotifycloning.demo.models.entities.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepositories extends CrudRepository<Artist, Long> {
}
