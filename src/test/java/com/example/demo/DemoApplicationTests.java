package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TasksRepository tasksRepository;
	@Test
	public void contextLoads() {
		Customer customer = customerRepository.findAll().get(0);
		System.out.print(customer.toString());
		Task task= tasksRepository.findAll().get(0);
		System.out.print(task.toString());
	}
	@Test
	public void customertest(){
		Optional<Customer> customerOptional = customerRepository.findByLastName("Paul");

		if(customerOptional.isPresent()){
			System.out.print("found customer" + customerOptional.get().toString());
		}
		else {
				System.out.print("not found ");
		}
	}


}
