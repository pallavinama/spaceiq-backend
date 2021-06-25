package com.spaceiq.bookingdeskservice.controller;

import com.spaceiq.bookingdeskservice.model.Desk;
import com.spaceiq.bookingdeskservice.model.Employee;
import com.spaceiq.bookingdeskservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = repository.findAll();
        return employeeList;
    }
    }
