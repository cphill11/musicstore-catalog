package com.trilogyed.musicstorecatalog.controller;

import com.trilogyed.musicstorecatalog.model.Track;
import com.trilogyed.musicstorecatalog.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/track")
public class TrackController {
    @Autowired
    TrackRepository repo;

    // create Track
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Track createTrack(@RequestBody Track track) {
        return repo.save(track);
    }

    // get all Tracks
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getAllTracks() {
        return repo.findAll();
    }

    // as shown by Dan's heroku-coffee example
    // get Track by ID
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Track getTrackByID(@PathVariable("id") long trackId) {
        Optional<Track> returnVal = repo.findById(trackId);
        if (!returnVal.isPresent()) {
            throw new IllegalArgumentException("No track with id " + trackId);
        }
        return returnVal.get();
    }

    // update Album
    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrack(@RequestBody Track track) {
        repo.save(track);
    }

    // delete Album
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(@PathVariable("id") long trackId) {
        repo.deleteById(trackId);
    }
}
