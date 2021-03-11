package com.bestapp.ordersapp.restaurants.model.persistence;


import com.bestapp.ordersapp.authentication.model.persitance.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;

@Table(name = "restaurants", schema = "orders")
@Entity
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Timestamp created_on;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userEntity;

    private String name;
    private String description;
    private String location;
    private LocalTime open_hour;
    private LocalTime close_hour;

    public RestaurantEntity() {
    }

    public RestaurantEntity(UserEntity userEntity, String name, String description, String location, LocalTime open_hour, LocalTime close_hour) {
        this.userEntity = userEntity;
        this.name = name;
        this.description = description;
        this.location = location;
        this.open_hour = open_hour;
        this.close_hour = close_hour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
}
