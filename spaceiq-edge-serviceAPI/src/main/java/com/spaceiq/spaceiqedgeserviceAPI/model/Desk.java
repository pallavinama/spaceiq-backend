package com.spaceiq.spaceiqedgeserviceAPI.model;

import java.util.Objects;

public class Desk {
    private Integer id;
    private String code;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desk desk = (Desk) o;
        return Objects.equals(id, desk.id) && Objects.equals(code, desk.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    @Override
    public String toString() {
        return "Desk{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    public Desk(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Desk() {
    }
}
