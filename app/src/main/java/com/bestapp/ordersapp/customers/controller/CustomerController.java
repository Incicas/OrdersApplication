package com.bestapp.ordersapp.customers.controller;


import com.bestapp.ordersapp.authentication.model.persitance.Role;
import com.bestapp.ordersapp.authentication.model.persitance.UserEntity;
import com.bestapp.ordersapp.authentication.service.UserService;
import com.bestapp.ordersapp.customers.model.dto.CustomerDTO;
import com.bestapp.ordersapp.customers.model.persistence.CustomerEntity;
import com.bestapp.ordersapp.customers.service.CustomerService;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customers")
@RestController


public class CustomerController {

    private UserService userService;
    private CustomerService customerService;

    @Autowired
    public CustomerController(UserService userService, CustomerService customerService){
        this.customerService = customerService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerEntity> register(@RequestBody CustomerDTO customerDTO){
        UserEntity userEntity = new UserEntity(customerDTO.getEmail(), customerDTO.getPassword(), Role.ROLE_CUSTOMER);
        userService.createUser(userEntity);
        CustomerEntity customerEntity = new CustomerEntity(
                userEntity,
                customerDTO.getName(),
                customerDTO.getPhone_number(),
                customerDTO.getAddress()
                );
        customerService.create(customerEntity);
        return ResponseEntity.ok(customerEntity);
    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllCustomers (){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id){
        userService.deleteUser(customerService.getCustomerById(id).getUserEntity());

        return ResponseEntity.ok().build();
    }

}
