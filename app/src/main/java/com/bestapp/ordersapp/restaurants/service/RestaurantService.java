package com.bestapp.ordersapp.restaurants.service;

import com.bestapp.ordersapp.restaurants.dao.RestaurantRepository;
import com.bestapp.ordersapp.restaurants.model.persistence.RestaurantEntity;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantEntity create(RestaurantEntity restaurantEntity){
        if (restaurantEntity.getOpen_hour().isAfter(restaurantEntity.getClose_hour())) { //TODO: Create custom Exception for open/close hours
            throw new RuntimeException("Open hour: "+restaurantEntity.getOpen_hour()+" can not be after close hour : "+restaurantEntity.getClose_hour());
        }
        return this.restaurantRepository.save(restaurantEntity);
    }

    public List<RestaurantEntity> getAll(){
        return restaurantRepository.findAll();
    }
    public RestaurantEntity getRestaurantById(Long id){
        return restaurantRepository.findById(id).orElseThrow(()->
                new RuntimeException("Restaurant with id "+id+" not found!")
        );

    }
 }
