package com.spotifycloning.demo.dto;

import jakarta.validation.constraints.NotEmpty;

public class AlbumDto {

    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Release year is required")
    private String release;

    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
