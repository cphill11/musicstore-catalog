package com.trilogyed.musicstorecatalog.controller;

import com.trilogyed.musicstorecatalog.model.Artist;
import com.trilogyed.musicstorecatalog.model.Label;
import com.trilogyed.musicstorecatalog.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/artist")
public class ArtistController {
    @Autowired
    ArtistRepository repo;

    // create Artist
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody Artist artist) {
        return repo.save(artist);
    }
    // get all Artists
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllArtists() {
        return repo.findAll();
    }
    // as shown by Dan's heroku-coffee example
    // get Artist by ID
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Artist getArtistByID(@PathVariable("id") long artistId) {
    Optional<Artist> returnVal = repo.findById(artistId);
        if (!returnVal.isPresent()) {
        throw new IllegalArgumentException("No artist with id " + artistId);
    }
        return returnVal.get();
}

    // update Artist
    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@RequestBody Artist artist) {
        repo.save(artist);
    }
    // delete Artist
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable("id") long artistId) {
        repo.deleteById(artistId);
    }
}
