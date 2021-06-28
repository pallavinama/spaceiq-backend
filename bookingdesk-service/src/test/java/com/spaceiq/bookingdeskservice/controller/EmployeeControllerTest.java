package com.spaceiq.bookingdeskservice.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spaceiq.bookingdeskservice.model.Employee;
import com.spaceiq.bookingdeskservice.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
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
@WebMvcTest(EmployeeController.class)

public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    EmployeeRepository repo;
    ObjectMapper mapper = new ObjectMapper();

    private Employee employee;
    private String employeeJson;
    private List<Employee> allEmployees = new ArrayList<>();
    private String allEmployeesJson;


    @Before
    public void setup() throws Exception {
        employee = new Employee();
        employee.setFirstName("Test Employee");
        employee.setLastName("testlastname");
        employee.setAddress("123 New main Street1");
        employee.setPhoneNumber(1231231231);
        employee.setEmail("testemployee@gmail.com");
        employee.setPassword("mypassword");
        employee.setAuthority("Basic");

        allEmployeesJson = mapper.writeValueAsString(employee);

        Employee employee1 = new Employee();
        employee.setFirstName("new");
        employee.setLastName("newlastname");
        employee.setAddress("456 New main Street1");
        employee.setPhoneNumber(777888777);
        employee.setEmail("newemployee@gmail.com");
        employee.setPassword("newpassword");
        employee.setAuthority("Basic");

        allEmployees.add(employee);
        allEmployees.add(employee1);

        allEmployeesJson = mapper.writeValueAsString(allEmployees);
    }


    @Test
    public void shouldReturnAllEmployees() throws Exception {
        given(repo.findAll()).willReturn(allEmployees);

        mockMvc.perform(
                get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json(allEmployeesJson)
                );
    }

//    @Test
//    public void shouldUpdateEmployeeAndReturnStatus200() throws Exception {
//        mockMvc.perform(
//                post("/api/employees")
//                        .content(allEmployeesJson)
//                        .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isOk());
//    }

}