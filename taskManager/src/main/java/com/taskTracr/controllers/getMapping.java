package com.taskTracr.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * README: This class is for the getMappings of all URL's. POST's will be handled in their respective controllers. 
 */
@Controller
public class getMapping {
    @GetMapping("/")
    public String index() {
        return "accountPages/home.html";
    }

    //These are the pages for ALL users
    @GetMapping("/login")
    public String login() {
        return "accountPages/login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "accountPages/register.html";
    }

    @GetMapping("/reset-password")
    public String resetPassword() {
        return "accountPages/resetPassword.html";
    }
}
