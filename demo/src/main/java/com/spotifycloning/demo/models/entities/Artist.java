package com.spotifycloning.demo.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tbl_artist")
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artist", length = 11)
    private long id;

    @NotEmpty(message = "Name is required")
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String instagram;

    @Column(length = 50, nullable = false)
    private String facebook;

    @Column(length = 50, nullable = false)
    private String twitter;

    @Column(length = 150, nullable = false)
    private String wikipedia;

    @NotEmpty(message = "Bio is required")
    @Column(length = 5000, nullable = false)
    private String bio;

    @ManyToMany
    @JoinTable(
            name = "tbl_artist_album",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> album;

    public Artist() {
    }

    public Artist(Long id, String name, String instagram, String facebook, String twitter, String wikipedia, String bio
    ) {
        this.id = id;
        this.name = name;
        this.instagram = instagram;
        this.facebook = facebook;
        this.twitter = twitter;
        this.wikipedia = wikipedia;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Album> getAlbum() {
        return album;
    }

    public void setAlbum(Set<Album> album) {
        this.album = album;
    }
}
