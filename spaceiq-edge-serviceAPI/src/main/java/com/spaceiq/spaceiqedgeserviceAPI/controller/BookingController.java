package com.spaceiq.spaceiqedgeserviceAPI.controller;

import com.spaceiq.spaceiqedgeserviceAPI.model.Booking;
import com.spaceiq.spaceiqedgeserviceAPI.model.Employee;
import com.spaceiq.spaceiqedgeserviceAPI.util.BookingClient;
import com.spaceiq.spaceiqedgeserviceAPI.util.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/edge")
public class BookingController {
    @Autowired
    private BookingClient bookingClient;

    @GetMapping("/bookings")
    @ResponseStatus(HttpStatus.OK)
    public List<Booking> getAllBookings() {
        List<Booking> bookingList = bookingClient.getAllBookings();
        return bookingList;
    }

    @PostMapping("/bookings")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking addBooking(@RequestBody Booking booking){
//        Booking existingBooking = bookingClient.findBookingByEmpDeskDate(booking.getEmployeeId(),booking.getDeskId(),booking.getDate());
//        if(existingBooking != null)
//            throw new IllegalArgumentException("A booking already exists for this employee, desk, date combination");
//
//        existingBooking = bookingClient.findBookingByDeskDate(booking.getDeskId(),booking.getDate());
//        if(existingBooking != null)
//            throw new IllegalArgumentException("A booking already exists for this desk, date combination");
//
//        existingBooking = bookingClient.findBookingByEmpDate(booking.getEmployeeId(),booking.getDate());
//        if(existingBooking != null)
//            throw new IllegalArgumentException("A booking already exists for this employee, date combination");
        bookingClient.addBooking(booking);
        return booking;
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable int id)
    {
        bookingClient.deleteById(id);
    }


}
