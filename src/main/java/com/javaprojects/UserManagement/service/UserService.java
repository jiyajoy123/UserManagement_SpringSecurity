package com.javaprojects.UserManagement.service;

import com.javaprojects.UserManagement.config.UserRegistrationDto;
import com.javaprojects.UserManagement.model.AppUser;
import com.javaprojects.UserManagement.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AppUserRepository userRepository;

    public void registerNewUser(UserRegistrationDto registrationDto) {
        AppUser user = new AppUser();
        user.setUsername(registrationDto.getUsername());

        // Encrypt the password before saving
        String encodedPassword = passwordEncoder.encode(registrationDto.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(registrationDto.getRole());

        userRepository.save(user);
    }

}
