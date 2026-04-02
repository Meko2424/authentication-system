package com.projects.auth_system.service;


import com.projects.auth_system.dto.RegisterRequest;
import com.projects.auth_system.entity.User;
import com.projects.auth_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // makes the class as business logic
public class AuthService {

    @Autowired
    private UserRepository userRepository; // injects user repo to use DB methods

    public String register(RegisterRequest request){
        User user = new User(); // create user object

        // set values from the request; copy data from DTO to entity
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return "User registered successfully";
    }
}
