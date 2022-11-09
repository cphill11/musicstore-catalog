package com.trilogyed.musicstorecatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.musicstorecatalog.model.Label;
import com.trilogyed.musicstorecatalog.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LabelController.class)
//@AutoConfigureMockMvc(addFilters = false)
public class LabelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LabelRepository repo;

    @Autowired
    private ObjectMapper mapper;


    private Label musicStoreLabel;

    private String musicStoreJson;

    private List<Label> allLabels = new ArrayList<>();

    private String allLabelsJson;


    @Before
    public void setup() throws Exception {
        // input
        musicStoreLabel = new Label();
        musicStoreLabel.setName("Label This");
        musicStoreLabel.setWebsite("LabelThis.com");

        musicStoreJson = mapper.writeValueAsString(musicStoreLabel);

        // output
        Label label = new Label();
        label.setId(1L);
        label.setName("Label This");
        label.setWebsite("LabelThis.com");

        allLabels.add(label);
        allLabelsJson = mapper.writeValueAsString(allLabels);
    }

    //from work done with RSVP-Service
    // Mock create method
    @Test
    public void shouldCreateNewLabelOnPostRequest() throws Exception {
        Label inputLabel  = new Label();
        inputLabel.setId(1L);
        inputLabel.setName("Label This");
        inputLabel.setWebsite("LabelThis.com");


        String inputJson = mapper.writeValueAsString(inputLabel);
        doReturn(musicStoreLabel).when(repo).save(inputLabel);
        mockMvc.perform(
                        post("/label")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(musicStoreJson));

    }

    // Mock get by ID method
    @Test
    public void shouldReturnLabelById() throws Exception {
        doReturn(Optional.of(musicStoreLabel)).when(repo).findById(1L);

        ResultActions result = mockMvc.perform(
                        get("/label/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(musicStoreJson))
                );
    }

    // Mock get all method
    @Test
    public void shouldReturnAllLabels() throws Exception {
        doReturn(allLabels).when(repo).findAll();

        mockMvc.perform(
                        get("/label"))
                .andExpect(status().isOk())
                .andExpect(content().json(allLabelsJson)
                );
    }

    // mock update method
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(
                        put("/label")
                                .content(musicStoreJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    // mock delete method
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/label/1")).andExpect(status().isNoContent());
    }

}