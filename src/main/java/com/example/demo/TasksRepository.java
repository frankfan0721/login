package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Task, Long> {

    List<Task> findByUserID(Long userID);
    List<Task> findAll();

    Optional<Task> findById(Long id);
}