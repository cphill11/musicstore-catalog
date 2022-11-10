package com.trilogyed.musicstorecatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.musicstorecatalog.model.Artist;
import com.trilogyed.musicstorecatalog.repository.ArtistRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ArtistController.class)
public class ArtistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArtistRepository repo;

    @Autowired
    private ObjectMapper mapper;

    private Artist musicStoreArtist;

    private String musicStoreJson;

    private List<Artist> allArtists= new ArrayList<>();
    private String allArtistsJson;

    // from Project 1
    @Before
    public void setup() throws Exception {
        // input
        musicStoreArtist = new Artist();
        musicStoreArtist.setName("Bonnie Clyde");
        musicStoreArtist.setInstagram("WeRobUBlind.com");
        musicStoreArtist.setTwitter("t8kur$$@IG");

        musicStoreJson = mapper.writeValueAsString(musicStoreArtist);

        // output
        Artist artist = new Artist();
        artist.setId(1L);
        artist.setName("Bonnie Clyde");
        artist.setInstagram("WeRobUBlind.com");
        artist.setTwitter("t8kur$$@IG");

        allArtists.add(artist);
        allArtistsJson = mapper.writeValueAsString(allArtists);
    }

    // from work done with RSVP-Service
    // Mock create method
    @Test
    public void shouldCreateNewArtistOnPostRequest() throws Exception {
        Artist inputArtist  = new Artist();
        inputArtist.setId(1L);
        inputArtist.setName("Bonnie Clyde");
        inputArtist.setInstagram("WeRobUBlind.com");
        inputArtist.setTwitter("t8kur$$@IG");

        String inputJson = mapper.writeValueAsString(inputArtist);
        doReturn(musicStoreArtist).when(repo).save(inputArtist);
        mockMvc.perform(
                        post("/artist")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(musicStoreJson));

    }

    // Mock get by ID method
    @Test
    public void shouldReturnArtistById() throws Exception {
        doReturn(Optional.of(musicStoreArtist)).when(repo).findById(1L);

        ResultActions result = mockMvc.perform(
                        get("/artist/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(musicStoreJson))
                );
    }

    // Mock get all method
    @Test
    public void shouldReturnAllLabels() throws Exception {
        doReturn(allArtists).when(repo).findAll();

        mockMvc.perform(
                        get("/artist"))
                .andExpect(status().isOk())
                .andExpect(content().json(allArtistsJson)
                );
    }

    // mock update method
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(
                        put("/artist")
                                .content(musicStoreJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    // mock delete method
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/artist/1")).andExpect(status().isNoContent());
    }
}