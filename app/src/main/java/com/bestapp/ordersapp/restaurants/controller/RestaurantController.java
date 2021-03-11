package com.bestapp.ordersapp.restaurants.controller;


import com.bestapp.ordersapp.authentication.model.persitance.Role;
import com.bestapp.ordersapp.authentication.model.persitance.UserEntity;
import com.bestapp.ordersapp.authentication.service.UserService;
import com.bestapp.ordersapp.restaurants.model.dto.RestaurantDTO;
import com.bestapp.ordersapp.restaurants.model.persistence.RestaurantEntity;
import com.bestapp.ordersapp.restaurants.service.RestaurantService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/restaurants")

@RestController

public class RestaurantController {


    private UserService userService;
    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(UserService userService, RestaurantService restaurantService){
        this.userService = userService;
        this.restaurantService = restaurantService;
    }
    @PostMapping("/register")
    public ResponseEntity<RestaurantEntity> register(@RequestBody RestaurantDTO restaurantDTO){
        UserEntity userEntity = new UserEntity(restaurantDTO.getEmail(),
                restaurantDTO.getPassword(),
                Role.ROLE_CUSTOMER);
        userService.createUser(userEntity);
        RestaurantEntity restaurantEntity = new RestaurantEntity(
                userEntity,
                restaurantDTO.getName(),
                restaurantDTO.getDescription(),
                restaurantDTO.getLocation(),
                restaurantDTO.getOpen_hour(),
                restaurantDTO.getClose_hour()
        );
        restaurantService.create(restaurantEntity);
        return ResponseEntity.ok(restaurantEntity);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantEntity>> getAllRestaurants(){
        return ResponseEntity.ok(restaurantService.getAll());

    }
    @GetMapping("/id")
    public ResponseEntity<RestaurantEntity> getRestaurantsById(@PathVariable Long id){
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable Long id){
        userService.deleteUser(restaurantService.getRestaurantById(id).getUserEntity());
        return ResponseEntity.ok().build();

    }

    
}
