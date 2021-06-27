package com.spaceiq.bookingdeskservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="desk")
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    @OneToMany(mappedBy = "deskId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desk desk = (Desk) o;
        return Objects.equals(id, desk.id) && Objects.equals(bookings, desk.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookings);
    }

    @Override
    public String toString() {
        return "Desk{" +
                "id='" + id + '\'' +
                ", bookings=" + bookings +
                '}';
    }

    public Desk(Integer id, String code, List<Booking> bookings) {
        this.id = id;
        this.code = code;
        this.bookings = bookings;
    }

    public Desk() {
    }
}


