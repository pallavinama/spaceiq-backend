package com.spaceiq.spaceiqedgeserviceAPI.controller;

import com.spaceiq.spaceiqedgeserviceAPI.model.Employee;
import com.spaceiq.spaceiqedgeserviceAPI.util.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/edge")
public class EmployeeController {
    @Autowired
    private EmployeeClient employeeClient;

//    @Autowired
//    private EmployeeClient employeeClient;

//    @RequestMapping(value = "/employees", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<Employee> getAllEmployees() {
//        System.out.println("Called this edge service. Getting all the employee!");
//        return employeeClient.findAll();
//    }

    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }


    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeClient.getEmployeeById(id);
    }


//    @PutMapping("/employee/{id}")
//    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employeeDetails){
//        return employeeClient.getEmployeeById(id);
//    }


    @PutMapping("/employee/{id}")
    public void updateEmployee(@RequestBody Employee employeeDetails, @PathVariable int id) {

        employeeClient.updateEmployee(employeeDetails,id);
    }

}



//    @PutMapping(value = "{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void updateCustomerById(@RequestBody Customer customer, @PathVariable int id) {
//        customerServiceClient.updateCustomer(customer, id);
//    }
