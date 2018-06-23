package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Task, Long> {

//    List<Customer> findByLastName(String lastName);
    List<Task> findAll();
}