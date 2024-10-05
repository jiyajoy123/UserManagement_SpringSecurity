package com.javaprojects.UserManagement.repo;

import com.javaprojects.UserManagement.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}


