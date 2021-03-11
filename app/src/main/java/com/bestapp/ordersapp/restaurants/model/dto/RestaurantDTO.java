package com.bestapp.ordersapp.restaurants.model.dto;

import java.time.LocalTime;

public class RestaurantDTO {

    private String email;
    private String password;
    private String name;
    private String description;
    private String location;
    private LocalTime open_hour;
    private LocalTime close_hour;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getOpen_hour() {
        return open_hour;
    }

    public void setOpen_hour(LocalTime open_hour) {
        this.open_hour = open_hour;
    }

    public LocalTime getClose_hour() {
        return close_hour;
    }

    public void setClose_hour(LocalTime close_hour) {
        this.close_hour = close_hour;
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", open_hour=" + open_hour +
                ", close_hour=" + close_hour +
                '}';
    }
}
