package com.spaceiq.bookingdeskservice.repository;

import com.spaceiq.bookingdeskservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    public List<Booking> findAllByDeskId(String deskId);

    public List<Booking> findAllByEmployeeId(Integer employeeId);

    @Query("SELECT b FROM Booking b WHERE b.employeeId = ?1 and b.deskId = ?2 and b.date = ?3")
    public Booking findBookingByEmpDeskDate(Integer employeeId, Integer deskId, Date date);

    @Query("SELECT b FROM Booking b WHERE b.deskId = ?1 and b.date = ?2")
    public Booking findBookingByDeskDate(Integer deskId, Date date);

    @Query("SELECT b FROM Booking b WHERE b.employeeId = ?1 and b.date = ?2")
    public Booking findBookingByEmpDate(Integer employeeId, Date date);
}

