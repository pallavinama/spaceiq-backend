package com.spaceiq.spaceiqedgeserviceAPI.util;

import com.spaceiq.spaceiqedgeserviceAPI.model.Booking;
import com.spaceiq.spaceiqedgeserviceAPI.model.Desk;
import com.spaceiq.spaceiqedgeserviceAPI.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(name = "bookingdesk-service")
public interface BookingClient {

    @GetMapping("/api/bookings")
    public List<Booking> getAllBookings();

//    @GetMapping("/api/employeeBookings")
//    public List<Booking> getBookingsByEmployeeId(@RequestBody Employee employee);
//

    @PostMapping("/api/bookings")
    public Booking addBooking(@RequestBody Booking booking);
//    public findBookingByEmpDeskDate(booking.getEmployeeId(),booking.getDeskId(),booking.getDate());

    @DeleteMapping("/api/bookings/{id}")
    public void deleteById(@PathVariable int id);

//    @RequestMapping(value = "/api/customer/{id}", method = RequestMethod.DELETE)
//    public void deleteCustomer(@PathVariable Integer id);

    @GetMapping("/api/desks")
    public List<Desk> getAllDesks() ;

    @GetMapping("/api/availableDesks")
    public List<Desk> getAvailableDesks( @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd")Date date);




}
