package com.spaceiq.bookingdeskservice.controller;

import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spaceiq.bookingdeskservice.model.Desk;
import com.spaceiq.bookingdeskservice.model.Employee;
import com.spaceiq.bookingdeskservice.repository.DeskRepository;
import com.spaceiq.bookingdeskservice.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(DeskController.class)


public class DeskControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    DeskRepository repo;
    ObjectMapper mapper = new ObjectMapper();

    private Desk desk;
    private String  deskJson;
    private List<Desk> allDesks = new ArrayList<>();
    private String allDesksJson;

    @Before
    public void setup() throws Exception {
        desk = new Desk();
        desk.setCode("TD1");

        allDesksJson = mapper.writeValueAsString(desk);
        Desk desk1 = new Desk();
        desk = new Desk();
        desk.setCode("TD2");

        allDesks.add(desk);
        allDesks.add(desk1);

        allDesksJson = mapper.writeValueAsString(allDesks);

    }
        @Test
        public void shouldReturnAllDesks() throws Exception {
            given(repo.findAll()).willReturn(allDesks);

            mockMvc.perform(
                    get("/api/desks"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(allDesksJson)
                    );
        }
    }