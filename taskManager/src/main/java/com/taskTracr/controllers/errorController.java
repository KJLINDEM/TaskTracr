package com.taskTracr.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class errorController {

    @GetMapping("/error") 
    public String error() {
        return "Error 404. You were redirected to a bad URL.";
    }
}
