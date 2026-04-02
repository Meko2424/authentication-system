package com.projects.auth_system.controller;


import com.projects.auth_system.dto.LoginRequest;
import com.projects.auth_system.dto.RegisterRequest;
import com.projects.auth_system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")   // all endpoints start with
//@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody @jakarta.validation.Valid RegisterRequest request){
        return authService.register(request);
    }

   @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request);
   }
}
