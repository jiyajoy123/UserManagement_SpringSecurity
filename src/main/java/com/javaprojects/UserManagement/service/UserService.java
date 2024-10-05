package com.javaprojects.UserManagement.service;

import com.javaprojects.UserManagement.config.UserRegistrationDto;
import com.javaprojects.UserManagement.model.AppUser;
import com.javaprojects.UserManagement.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AppUserRepository userRepository;

    public void registerNewUser(UserRegistrationDto registrationDto) {
        AppUser user = new AppUser();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword()); // You can add password encryption here
        user.setRole(registrationDto.getRole());

        userRepository.save(user);
    }
}
