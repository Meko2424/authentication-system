package com.projects.auth_system.service;


import com.projects.auth_system.dto.AuthResponse;
import com.projects.auth_system.dto.LoginRequest;
import com.projects.auth_system.dto.MessageResponse;
import com.projects.auth_system.dto.RegisterRequest;
import com.projects.auth_system.entity.User;
import com.projects.auth_system.repository.UserRepository;
import com.projects.auth_system.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service // makes the class as business logic
public class AuthService {

    @Autowired
    private UserRepository userRepository; // injects user repo to use DB methods

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public MessageResponse register(RegisterRequest request){

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return new MessageResponse("Email already exists") ;
        }


        User user = new User(); // create user object

        // set values from the request; copy data from DTO to entity
        user.setEmail(request.getEmail());

        // Hash password before saving
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return new MessageResponse("User registered successfully") ;
    }

    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
