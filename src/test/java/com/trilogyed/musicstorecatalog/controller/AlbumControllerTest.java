package com.trilogyed.musicstorecatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.musicstorecatalog.model.Album;
import com.trilogyed.musicstorecatalog.repository.AlbumRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
@AutoConfigureMockMvc(addFilters = false)

public class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

     @MockBean
     private AlbumRepository repo;
     private Album gameStoreAlbum;
     private String gameStoreJson;
     private List<Album> allAlbums = new ArrayList<>();
     private String allAlbumsJson;

    private ObjectMapper mapper;

    // from Project 1
    @Before
    public void setup() throws Exception {
        // input
        gameStoreAlbum = new Album();
        gameStoreAlbum.setTitle("I need sleep");
        gameStoreAlbum.setArtistId(2);
        // how do I do date here?
//        gameStoreAlbum.setReleaseDate();
        gameStoreAlbum.setLabelId(16);
        // why is this angry?
//        gameStoreAlbum.setListPrice(9.99);

        gameStoreJson = mapper.writeValueAsString(gameStoreAlbum);

        // output
        Album album = new Album();
        album.setId(1);
        album.setTitle("I need sleep");
        album.setArtistId(2);
        // how do I do date here?
//        album.setReleaseDate();
        album.setLabelId(16);
        // why is this angry?
//       album.setListPrice(9.99);

        allAlbums.add(album);
        allAlbumsJson = mapper.writeValueAsString(album);
    }


    // from work done w/ RSVP-service
    // test create method
    @Test
    public void shouldCreateNewAlbumOnPostRequest() throws Exception {
        Album inputAlbum = new Album();
        inputAlbum.setId(1);
        inputAlbum.setTitle("I need sleep");
        inputAlbum.setArtistId(2);
//        inputAlbum.setReleaseDate();
        inputAlbum.setLabelId(16);
//        inputAlbum.setListPrice(9.99);

        String inputJson = mapper.writeValueAsString(inputAlbum);
        doReturn(gameStoreAlbum).when(repo).save(inputAlbum);

        mockMvc.perform(
                        post("/album")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(gameStoreJson));

    }

    // test doesn't want to accept 1
    @Test
    public void shouldReturnAlbumById() throws Exception {
        doReturn(Optional.of(gameStoreAlbum)).when(repo).findById(1);

        ResultActions result = mockMvc.perform(
                        get("/album/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(gameStoreJson))
                );
    }

    @Test
    public void shouldReturnAlbumOnValidGetRequest() throws Exception {

        // options?  makes me use findByID
        doReturn(allAlbums).when(repo).findByID("I need sleep");

        mockMvc.perform(
                        get("/album")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(allAlbumsJson)
                );
    }

    @Test
    public void shouldReturnAllConsoles() throws Exception {
        doReturn(allAlbums).when(repo).findAll();

        mockMvc.perform(
                        get("/album"))
                .andExpect(status().isOk())
                .andExpect(content().json(allAlbumsJson)
                );
    }

    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(
                        put("/album")
                                .content(gameStoreJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/album/1")).andExpect(status().isNoContent());
    }

}