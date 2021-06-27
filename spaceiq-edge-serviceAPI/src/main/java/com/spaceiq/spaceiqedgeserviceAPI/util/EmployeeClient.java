package com.spaceiq.spaceiqedgeserviceAPI.util;

import com.spaceiq.spaceiqedgeserviceAPI.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "employee-service")

public interface EmployeeClient {

//    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
////    public List<Employee>findAll();
//    public Employee findById(Integer id);

    //public interface EmployeeClient extends JpaRepository<Employee, Integer> {
//
    @GetMapping("/api/employee")
    public List<Employee> getAllEmployees();

    @GetMapping("/api/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id);

    @PutMapping("/api/employee/{id}")
    public void updateEmployee(@RequestBody Employee employeeDetails,@PathVariable int id);

    }


//    @RequestMapping(value = “/customer”, method = RequestMethod.PUT)
//    public void updateCustomer(@RequestBody Customer customer, @PathVariable Integer id);



//public interface EmployeeClient extends JpaRepository<Employee, Integer> {
//
//    @GetMapping("employee/{id}")
//    public Employee getEmployeeById();
//
//    @PutMapping("employee/{id}")
//    public Employee updateEmployee(@RequestBody Employee employee);
//    }