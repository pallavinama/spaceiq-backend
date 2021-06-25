package com.spaceiq.bookingdeskservice.repository;

import com.spaceiq.bookingdeskservice.model.Booking;
import com.spaceiq.bookingdeskservice.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeskRepository extends JpaRepository<Desk, String> {
}
