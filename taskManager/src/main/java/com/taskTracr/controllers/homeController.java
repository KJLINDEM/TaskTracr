package com.taskTracr.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.taskTracr.models.user;

@Controller
public class homeController {
    //Data will temporarily be stored in an arrayList until PostGreSQL DB is setup. 
    private List<user> userRepo = new ArrayList<user>();
    private user newUser = new user();

    //DISCUSS: Mappings are to the resources/static directory for Spring Boot
    //TODO: Is it okay that I include the .html file extension since there is no application.properties to change this? 
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

    @PostMapping("/register") 
    public String regisetUser(
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String email, 
        @RequestParam String password,
        @RequestParam String passwordConfirmed) {
             /* The following checks happen here:
             * 1. Validate Email (RegEx)
             * 2. Check that email is not already in 'DB'
             * 3. Passwords must match
             * 4. */
            
            
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setEmail(email);
            newUser.setUserHash(passwordConfirmed);

            return "redirect:/login";
        }

    private boolean emailValidation(final String email) {
        final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
