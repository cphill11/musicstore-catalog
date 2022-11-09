package com.trilogyed.musicstorecatalog.controller;

import com.trilogyed.musicstorecatalog.model.Album;
import com.trilogyed.musicstorecatalog.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {
    @Autowired
    AlbumRepository repo;

    // create Album
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody Album album) {
        return repo.save(album);
    }

    // get all Albums
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAllAlbums() {
        return repo.findAll();
    }

    // as shown by Dan's heroku-coffee example
    // get Album by ID
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album getAlbumByID(@PathVariable("id") long albumId) {
        Optional<Album> returnVal = repo.findById(albumId);
        if (!returnVal.isPresent()) {
            throw new IllegalArgumentException("No album with id " + albumId);
        }
        return returnVal.get();
    }

    // update Album
    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@RequestBody Album album) {
        repo.save(album);
    }

    // delete Album
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable("id") long albumId) {
        repo.deleteById(albumId);
    }
}
