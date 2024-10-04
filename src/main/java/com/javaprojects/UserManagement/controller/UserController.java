package com.javaprojects.UserManagement.controller;

import com.javaprojects.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // Logic to return the authenticated user's profile
        return (ResponseEntity<User>) ResponseEntity.ok();
    }

    @GetMapping("/admin/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        // Logic to return all users for admins
        return (ResponseEntity<List<User>>) ResponseEntity.ok();
    }
}
