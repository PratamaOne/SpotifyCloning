package com.spotifycloning.demo.controllers;

import com.spotifycloning.demo.dto.ResponseData;
import com.spotifycloning.demo.models.entities.Artist;
import com.spotifycloning.demo.services.ArtistServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistServices artistServices;

    // Insert || Create
    @PostMapping
    public ResponseEntity<ResponseData<Artist>> create(@Valid @RequestBody Artist artist, Errors errors) {

        ResponseData<Artist> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(artistServices.save(artist));
        return ResponseEntity.ok(responseData);
    }

    // Find All Artist List
    @GetMapping
    public Iterable<Artist> findAll() {
        return artistServices.findAll();
    }

    // Delete By Id Parameter
    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") long id) {
        artistServices.removeOne(id);
    }

    // Find One By Id Parameter
    @GetMapping("/{id}")
    public Artist findOne(@PathVariable("id") Long id) {
        return artistServices.findOne(id);
    }

    // For Update Data Artist
    @PutMapping
    public ResponseEntity<ResponseData<Artist>> update(@Valid @RequestBody Artist artist, Errors errors) {

        ResponseData<Artist> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(artistServices.save(artist));
        return ResponseEntity.ok(responseData);
    }
}
