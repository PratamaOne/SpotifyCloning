package com.spotifycloning.demo.controllers;

import com.mysql.cj.log.Log;
import com.spotifycloning.demo.dto.AlbumDto;
import com.spotifycloning.demo.dto.ResponseData;
import com.spotifycloning.demo.models.entities.Album;
import com.spotifycloning.demo.services.AlbumServices;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumServices albumServices;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Album>> create(@Valid @RequestBody AlbumDto albumDto, Errors errors) {

        ResponseData<Album> responseData = new ResponseData<>();
        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Album album = modelMapper.map(albumDto, Album.class);

        responseData.setStatus(true);
        responseData.setPayload(albumServices.save(album));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Album> findAll() {
        return albumServices.findALl();
    }

    @GetMapping("/{id}")
    public Album findOne(@PathVariable Long id) {
        return albumServices.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Album>> update(@Valid @RequestBody AlbumDto albumDto, Errors errors) {

        ResponseData<Album> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Album album = modelMapper.map(albumDto, Album.class);

        responseData.setStatus(true);
        responseData.setPayload(albumServices.save(album));
        return ResponseEntity.ok(responseData);
    }
}
