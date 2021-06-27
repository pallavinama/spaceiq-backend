package com.spaceiq.bookingdeskservice.controller;

import com.spaceiq.bookingdeskservice.model.Desk;
import com.spaceiq.bookingdeskservice.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DeskController {
    @Autowired
    DeskRepository repository;

    @GetMapping("/api/desks")
    public List<Desk> getAllDesks() {
        List<Desk> deskList = repository.findAll();
        return deskList;
    }

    @GetMapping("/api/availableDesks")
    public List<Desk> getAvailableDesks(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        List<Desk> deskList = repository.findAvailableDesks(date);
        return deskList;
    }

    @PostMapping("/api/desks")
    public Desk addDesk(@RequestBody Desk desk) {
        repository.save(desk);
        return desk;
    }
}
