package com.trilogyed.musicstorecatalog.repository;

import com.trilogyed.musicstorecatalog.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findById(String artist);
}
