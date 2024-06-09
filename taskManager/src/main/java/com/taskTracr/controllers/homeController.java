package com.taskTracr.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    //DISCUSS: Mappings are to the resources/static directory for Spring Boot
    //TODO: Is it okay that I include the .html file extension since there is no application.properties to change this? 
    @GetMapping("/home")
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
