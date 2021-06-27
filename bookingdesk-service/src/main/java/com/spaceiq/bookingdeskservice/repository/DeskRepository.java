package com.spaceiq.bookingdeskservice.repository;

import com.spaceiq.bookingdeskservice.model.Booking;
import com.spaceiq.bookingdeskservice.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Date> {
    @Query("SELECT d FROM Desk d WHERE d.id NOT IN (SELECT b.deskId FROM Booking b WHERE b.date = ?1)")
    public List<Desk> findAvailableDesks(Date date);

}
