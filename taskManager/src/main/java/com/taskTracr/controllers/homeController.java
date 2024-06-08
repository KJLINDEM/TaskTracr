package com.taskTracr.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    
    @GetMapping("/") 
    public String home() {
        return "Welcome to taskTracr!";
    }

    @GetMapping("/tasks") 
    public String tasks() {
        return "This is the tasks page";
    }
}
