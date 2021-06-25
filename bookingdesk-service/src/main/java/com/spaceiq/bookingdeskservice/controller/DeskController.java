package com.spaceiq.bookingdeskservice.controller;

import com.spaceiq.bookingdeskservice.model.Desk;
import com.spaceiq.bookingdeskservice.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/api/desks")
    public Desk addDesk(@RequestBody Desk desk) {
        repository.save(desk);
        return desk;
    }
}
