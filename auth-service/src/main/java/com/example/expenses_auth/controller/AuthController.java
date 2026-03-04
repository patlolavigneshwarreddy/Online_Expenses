package com.example.expenses_auth.controller;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expenses_auth.security.CustomUserDetails;
import com.example.expenses_auth.security.JwtUtil;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

	private static final org.slf4j.Logger logger =
            LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<String> login(@Validated @RequestBody LoginRequest req) {
//		log.info("Login API: authentication");
		logger.info("User try to login with : "+req);
        logger.warn("User try to login with : "+req);
        logger.error("User try to login with : "+req);
		try {
			Authentication auth = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(req.username(), req.password()));

			CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
			String role = user.getAuthorities().iterator().next().getAuthority().replace("ROLE_", "");
			Long userId = user.getUserId();

			String token = jwtUtil.generateToken(user.getUsername(), role, userId);
			return ResponseEntity.ok(token);
		} catch (AuthenticationException ex) {
//			log.warn("Authentication failed for user {}: {}", req.username(), ex.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}
}
