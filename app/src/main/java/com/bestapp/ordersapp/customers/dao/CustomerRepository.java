package com.bestapp.ordersapp.customers.dao;

import com.bestapp.ordersapp.customers.model.persistence.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
}
