//package com.trilogyed.musicstorecatalog.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.trilogyed.musicstorecatalog.model.Track;
//import com.trilogyed.musicstorecatalog.repository.TrackRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.doReturn;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(TrackController.class)
//@AutoConfigureMockMvc(addFilters = false)
//
//public class TrackControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TrackRepository repo;
//    private Track musicStoreTrack;
//    private String musicStoreJson;
//    private List<Track> allTracks = new ArrayList<>();
//    private String allTracksJson;
//
//    private ObjectMapper mapper;
//
//    // from Project 1
//    @Before
//    public void setup() throws Exception {
//        // input
//        musicStoreTrack = new Track();
//        musicStoreTrack.setAlbumId(1);
//        musicStoreTrack.setTitle("Doggos go wild");
//        musicStoreTrack.setRunTime(6);
//
//        musicStoreJson = mapper.writeValueAsString(musicStoreTrack);
//
//        // output
//        Track track = new Track();
//        track.setAlbumId(1);
//        track.setTitle("Doggos go wild");
//        track.setRunTime(6);
//
//
//        allTracks.add(track);
//        allTracksJson = mapper.writeValueAsString(allTracks);
//    }
//
//    //from work done with RSVP-Service
////    @Test
////    public void shouldCreateNewTrackOnPostRequest() throws Exception {
////        Track inputTrack = new Track();
////        inputTrack.setId(1);
////        inputTrack.setAlbumId(1);
////        inputTrack.setTitle("Doggos go wild");
////        inputTrack.setRunTime(6);
////
////        String inputJson = mapper.writeValueAsString(inputTrack);
////        doReturn(musicStoreTrack).when(repo).save(inputTrack);
////
////        mockMvc.perform(
////                        post("/track")
////                                .content(inputJson)
////                                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isCreated())
////                .andExpect(content().json(musicStoreJson));
////
////    }
////}
//    // test doesn't want to accept 1
////    @Test
////    public void shouldReturnTrackById() throws Exception {
////        doReturn(Optional.of(musicStoreTrack)).when(repo).findById(1);
////
////        ResultActions result = mockMvc.perform(
////                        get("/track/1"))
////                .andExpect(status().isOk())
////                .andExpect((content().json(musicStoreJson))
////                );
////    }
//
////    @Test
////    public void shouldReturnTrackOnValidGetRequest() throws Exception {
////
//////        doReturn(allTracks).when(repo).findBy("Sony");
////
////        // verify route
////        mockMvc.perform(
////                        get("/track")
////                                .contentType(MediaType.APPLICATION_JSON)
////                )
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(content().json(allTracksJson)
////                );
////    }
//
////    @Test
////    public void shouldReturnAllTracks() throws Exception {
////        doReturn(allTracks).when(repo).findAll();
////
////        mockMvc.perform(
////                        get("/track"))
////                .andExpect(status().isOk())
////                .andExpect(content().json(allTracksJson)
////                );
////    }
//
////    @Test
////    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
////        mockMvc.perform(
////                        put("/track")
////                                .content(musicStoreJson)
////                                .contentType(MediaType.APPLICATION_JSON)
////                )
////                .andExpect(status().isNoContent());
////    }
//
////    @Test
////    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
////        mockMvc.perform(delete("/track/1")).andExpect(status().isNoContent());
////    }
////}