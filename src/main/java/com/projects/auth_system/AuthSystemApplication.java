package com.projects.auth_system;


import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@SpringBootApplication
public class AuthSystemApplication {

	public static void main(String[] args) {

		// Load .env file
		Dotenv dotenv = Dotenv.load();

		// Set system properties so Spring can read them
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		//System.setProperty("SPRING_SECURITY_USER_NAME", dotenv.get("SPRING_SECURITY_USER_NAME"));
		//System.setProperty("SPRING_SECURITY_USER_PASSWORD", dotenv.get("SPRING_SECURITY_USER_PASSWORD"));

//		var key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//		String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
//
//		System.out.println("JWT Secret: " + encodedKey);

		SpringApplication.run(AuthSystemApplication.class, args);
	}
}