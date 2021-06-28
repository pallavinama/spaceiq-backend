package com.spaceiq.spaceiqedgeserviceAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class Booking {
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private Integer deskId;
    private Integer employeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDeskId() {
        return deskId;
    }

    public void setDeskId(Integer deskId) {
        this.deskId = deskId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(date, booking.date) && Objects.equals(deskId, booking.deskId) && Objects.equals(employeeId, booking.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, deskId, employeeId);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", date=" + date +
                ", deskId=" + deskId +
                ", employeeId=" + employeeId +
                '}';
    }

    public Booking(Integer id, Date date, Integer deskId, Integer employeeId) {
        this.id = id;
        this.date = date;
        this.deskId = deskId;
        this.employeeId = employeeId;
    }

    public Booking() {
    }
}
