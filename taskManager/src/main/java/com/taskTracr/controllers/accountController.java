package com.taskTracr.controllers;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.taskTracr.models.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Controller
public class accountController {
    //Data will temporarily be stored in an arrayList until PostGreSQL DB is setup. 
    private List<user> userRepo = new ArrayList<user>();
    private user newUser = new user();
    private validation registrationValid = new validation();

    @PostMapping("/register") 
    public String regisetUser(
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String email, 
        @RequestParam String password,
        @RequestParam String passwordConfirmed,
        RedirectAttributes redirectAttributes) {
            registrationValid = validateRegistration(email, password, passwordConfirmed, userRepo);
            if(!registrationValid.getValid()) {
                //Display error message for user by applying errorMessage class
                return registrationValid.getRedirect();
            }
            //Display success message by applying successMessage class & add user
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setEmail(email);
            newUser.setCreatedAt();
            System.out.println("Account created at: " + newUser.getCreatedAt());
            redirectAttributes.addFlashAttribute("successMessage", registrationValid.getMessage());
            return registrationValid.getRedirect();
        }

    
    //Method to validate email using RFC5322 regex. 
    private boolean validateEmail(final String email) {
        final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /*
     * Method to validate registration data based on the following conditionals: 
     * 1. Email is valid format
     * 2. Account does NOT exist already
     * 3. Both passwords match
     */
    private validation validateRegistration(String email, String password, String passwordConfirmed, List<user> userRepo) {
            /* The following checks happen here:
             * 1. Validate Email (RegEx)
             * 2. Check that email is not already in 'DB'
             * 3. Passwords must match
             * 4. */
        validation validate = new validation();
        validate.setValid(false);
        if(!validateEmail(email)) {
            validate.setMessage("Email is incorrect format. Please try again");
            validate.setRedirect("redirect:/register?errorMessage=" + validate.getMessage() + "&displayStyle=inline-block");
            return validate;
        }

        for(user user : userRepo) {
            if(user.getEmail().equals(email)) {
                validate.setMessage("Email already exists. Please log in instead");
                validate.setRedirect("redirect:/register?errorMessage=" + validate.getMessage() + "&displayStyle=inline-block");
                return validate;
            }
        }

        if(!password.equals(passwordConfirmed)) {
            validate.setMessage("Passwords are incorrect. Please try again");
            validate.setRedirect("redirect:/register?errorMessage=" + validate.getMessage() + "&displayStyle=inline-block");
            return validate;
        }

        validate.setValid(true);
        validate.setMessage("Account successfully created. Now try logging in :-)");
        validate.setRedirect("redirect:/register?successMessage=" + validate.getMessage() + "&displayStyle=inline-block");
        validate.setRedirect("redirect:/login");
        return validate;
    }

    //Method to create a pseudorandom 16 byte salt which equates to 24 characters using java.util.SecureRandom;
    @SuppressWarnings("unused")
    private String createSalt() {
        Random random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Hash the password using SHA-256
    //TODO: Modify algorithm to use two pointer approach and append password.
    @SuppressWarnings("unused")
    private String hashPassword(String saltedPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
