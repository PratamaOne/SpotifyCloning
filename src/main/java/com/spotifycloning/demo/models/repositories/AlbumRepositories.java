package com.spotifycloning.demo.models.repositories;

import com.spotifycloning.demo.models.entities.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepositories extends CrudRepository<Album, Long> {
}
