package com.bestapp.ordersapp.customers.service;

import com.bestapp.ordersapp.customers.dao.CustomerRepository;
import com.bestapp.ordersapp.customers.model.persistence.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public CustomerEntity create(CustomerEntity customerEntity){
         return this.customerRepository.save(customerEntity);
    }

    public List<CustomerEntity> getAllCustomers (){
        return this.customerRepository.findAll();
    }
    public CustomerEntity getCustomerById(Long id){
        return this.customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Customer with id : "+id+" does not exist !"));
    }

}
