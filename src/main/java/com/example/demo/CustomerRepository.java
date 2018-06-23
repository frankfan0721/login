package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

//    List<Customer> findByLastName(String lastName);
    List<Customer> findAll();

    Optional<Customer> findByUsername(String username);
    Optional<Customer> Password(String password);


}