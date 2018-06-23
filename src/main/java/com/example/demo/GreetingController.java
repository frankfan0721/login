package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TasksRepository tasksRepository;


    @GetMapping("/login")
    public String greeting(@RequestParam(name="Username", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("Username", name);
        model.addAttribute("Password",name);





        return "login";
    }

    @PostMapping("/verify")
    public String verify(@RequestParam(name="Username", required=false, defaultValue="World") String name,@RequestParam(name="Password", required=false, defaultValue="World") String password, Model model) {

        if(customerRepository.findByUsername(name).isPresent()){
            Customer customer = customerRepository.findByUsername(name).get();
            customer.getUsername().equals(name);

            if (customer.getPassword().equals(password)) {
                model.addAttribute("Username", name);
                model.addAttribute("Password", password);
                List<Task> taskList = tasksRepository.findAll();
                System.out.print(taskList.toString());

                model.addAttribute("taskList", taskList);

                return "table";
            } else {
                model.addAttribute("error", "Password doesn't match");
                return "login";
            }
        } else {
            model.addAttribute("error", "Customer Doesn't exist");
            return "login";
        }




    }


    @PostMapping("/table")
    public String table(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        Customer customer = customerRepository.findAll().get(0);
        System.out.print(customer.toString());
        List<Task> taskList = tasksRepository.findAll();
        System.out.print(taskList.toString());

        model.addAttribute("taskList", taskList);


        return "table";
    }



}