package com.example.expenses_auth.controller;

public record RegisterResponse(
		Long userId,
        String username,
        String role,
        String message
) {}
