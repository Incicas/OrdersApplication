package com.bestapp.ordersapp.restaurants.dao;

import com.bestapp.ordersapp.restaurants.model.persistence.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
