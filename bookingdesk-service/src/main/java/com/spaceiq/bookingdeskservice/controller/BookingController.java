package com.spaceiq.bookingdeskservice.controller;

import com.spaceiq.bookingdeskservice.model.Booking;
import com.spaceiq.bookingdeskservice.model.Desk;
import com.spaceiq.bookingdeskservice.model.Employee;
import com.spaceiq.bookingdeskservice.repository.BookingRepository;
import com.spaceiq.bookingdeskservice.repository.DeskRepository;
import com.spaceiq.bookingdeskservice.repository.EmployeeRepository;
import com.sun.javafx.sg.prism.EffectFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository repository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DeskRepository deskRepository;

    @GetMapping("/api/bookings")
    public List<Booking> getAllBookings() {
        List<Booking> bookingList = repository.findAll();
        return bookingList;
    }

    @GetMapping("/api/employeeBookings")
    public List<Booking> getBookingsByEmployeeId(@RequestBody Employee employee) {
        List<Booking> bookingList = repository.findAllByEmployeeId(employee.getId());
        return bookingList;
    }

    @PostMapping("/api/bookings")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking addBooking(@RequestBody Booking booking) {
        repository.save(booking);
        return booking;
    }

    @DeleteMapping("/api/bookings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable int id){
        repository.deleteById(id);
    }
}
