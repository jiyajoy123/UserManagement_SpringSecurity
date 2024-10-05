package com.javaprojects.UserManagement.controller;

import com.javaprojects.UserManagement.config.UserRegistrationDto;
import com.javaprojects.UserManagement.model.AppUser;
import com.javaprojects.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Controller
    public class RegistrationController {

        @Autowired
        private UserService userService;

        @GetMapping("/register")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new UserRegistrationDto());
            return "register";
        }

        @PostMapping("/register")
        public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
            userService.registerNewUser(registrationDto);
            return "redirect:/register?success";
        }
    }

    }

