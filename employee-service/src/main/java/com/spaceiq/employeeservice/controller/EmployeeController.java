package com.spaceiq.employeeservice.controller;


import com.spaceiq.employeeservice.model.Employee;
import com.spaceiq.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping(value = "/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping("employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepo.getById(id);
    }


    @PutMapping("employee/{id}")
    public void updateEmployee(@RequestBody Employee employeeDetails, @PathVariable int id) {
        if (employeeDetails.getId() == null) {
            employeeDetails.setId(id);
        }

        if (employeeDetails.getId() != id) {
            throw new IllegalArgumentException("Employee ID must match parameter given");
        }
        employeeRepo.save(employeeDetails);
    }

    @DeleteMapping(value = "employee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeRepo.deleteById(id);
    }


}



