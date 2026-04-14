package com.projects.auth_system.controller;


import com.projects.auth_system.dto.AuthResponse;
import com.projects.auth_system.dto.LoginRequest;
import com.projects.auth_system.dto.MessageResponse;
import com.projects.auth_system.dto.RegisterRequest;
import com.projects.auth_system.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")   // all endpoints start with
//@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public MessageResponse register(@RequestBody @Valid RegisterRequest request){
        return authService.register(request);
    }

   @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
   }

    @GetMapping("/test")
    public String test() {
        return "You are authenticated!";
    }
}
