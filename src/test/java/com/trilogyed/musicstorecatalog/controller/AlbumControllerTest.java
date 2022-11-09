//package com.trilogyed.musicstorecatalog.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.trilogyed.musicstorecatalog.model.Album;
//import com.trilogyed.musicstorecatalog.repository.AlbumRepository;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.testng.annotations.Test;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(AlbumController.class)
//@AutoConfigureMockMvc(addFilters = false)
//
//public class AlbumControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AlbumRepository repo;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//     private Album musicStoreAlbum;
//     private String musicStoreJson;
//     private List<Album> allAlbums = new ArrayList<>();
//     private String allAlbumsJson;
//
//
////    // from Project 1
//    @Before
//    public void setup() throws Exception {
//        // input
//        musicStoreAlbum = new Album();
//        musicStoreAlbum.setTitle("I need sleep");
//        musicStoreAlbum.setArtistId(2);
////        musicStoreAlbum.setReleaseDate();
//        musicStoreAlbum.setLabelId(16);
//        musicStoreAlbum.setListPrice(new BigDecimal("9.99"));
//
//        musicStoreJson = mapper.writeValueAsString(musicStoreAlbum);
//
//        // output
//        Album album = new Album();
//        album.setId(1);
//        album.setTitle("I need sleep");
//        album.setArtistId(2);
////        album.setReleaseDate();
//        album.setLabelId(16);
//        album.setListPrice(new BigDecimal("9.99"));
//
//        allAlbums.add(album);
//        allAlbumsJson = mapper.writeValueAsString(album);
//    }
//
//    // from work done w/ RSVP-service
//    // test create method
////    @Test
////    public void shouldCreateNewAlbumOnPostRequest() throws Exception {
////        Album inputAlbum = new Album();
////        inputAlbum.setId(1);
////        inputAlbum.setTitle("I need sleep");
////        inputAlbum.setArtistId(2);
//////        inputAlbum.setReleaseDate();
////        inputAlbum.setLabelId(16);
////        inputAlbum.setListPrice(new BigDecimal("9.99"));
////
////        String inputJson = mapper.writeValueAsString(inputAlbum);
////        doReturn(musicStoreAlbum).when(repo).save(inputAlbum);
////
////        mockMvc.perform(
////                        post("/album")
////                                .content(inputJson)
////                                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isCreated())
////                .andExpect(content().json(musicStoreJson));
////
////    }
//
//    // test doesn't want to accept 1
//    @Test
//    public void shouldReturnAlbumById() throws Exception {
//        doReturn(Optional.of(musicStoreAlbum)).when(repo).findById(1L);
//
//        ResultActions result = mockMvc.perform(
//                        get("/album/1"))
//                .andExpect(status().isOk())
//                .andExpect((content().json(musicStoreJson))
//                );
//    }
//
//////    @Test
//////    public void shouldReturnAlbumOnValidGetRequest() throws Exception {
//////
//////        // options?  makes me use findByID
//////        doReturn(allAlbums).when(repo).findByTitle("I need sleep");
//////
//////        mockMvc.perform(
//////                        get("/album/{title}")
//////                                .contentType(MediaType.APPLICATION_JSON)
//////                )
//////                .andDo(print())
//////                .andExpect(status().isOk())
//////                .andExpect(content().json(allAlbumsJson)
//////                );
//////    }
//////
//////    @Test
//////    public void shouldReturnAllAlbums() throws Exception {
//////        doReturn(allAlbums).when(repo).findAll();
//////
//////        mockMvc.perform(
//////                        get("/album"))
//////                .andExpect(status().isOk())
//////                .andExpect(content().json(allAlbumsJson)
//////                );
//////    }
//////
//////    @Test
//////    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
//////        mockMvc.perform(
//////                        put("/album")
//////                                .content(musicStoreJson)
//////                                .contentType(MediaType.APPLICATION_JSON)
//////                )
//////                .andExpect(status().isNoContent());
//////    }
//////
//////    @Test
//////    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
//////        mockMvc.perform(delete("/album/1")).andExpect(status().isNoContent());
//////    }
////
//}