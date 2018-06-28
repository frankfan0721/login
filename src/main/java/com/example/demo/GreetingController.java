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
    public String verify(@RequestParam(name="Username", required=true) String username,
                         @RequestParam(name="Password", required=true) String password,
                         Model model) {

        if(customerRepository.findByUsername(username).isPresent()){
            Customer customer = customerRepository.findByUsername(username).get();
            customer.getUsername().equals(username);

            if (customer.getPassword().equals(password)) {

//                model.addAttribute("Username", name);
//                model.addAttribute("Password", password);
//                model.addAttribute("UserID", customer.getId());

                List<Task> taskList = tasksRepository.findByUserID(customer.getId());
//                List<Task> taskList = tasksRepository.findAll();
//                System.out.print(taskList.toString());

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




}