package com.projects.auth_system.controller;


import com.projects.auth_system.dto.RegisterRequest;
import com.projects.auth_system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")   // all endpoints start with
//@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @Value("${spring.security.user.name}")
    private String username;

    @GetMapping("/test-auth")
    public String test() {
        return "Current user is: " + username;
    }
}
