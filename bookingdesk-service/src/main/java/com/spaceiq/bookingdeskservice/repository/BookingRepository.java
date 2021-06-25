package com.spaceiq.bookingdeskservice.repository;

import com.spaceiq.bookingdeskservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    public List<Booking> findAllByDeskId(String deskId);

    public List<Booking> findAllByEmployeeId(Integer employeeId);
}

