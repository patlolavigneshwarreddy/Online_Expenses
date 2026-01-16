package com.example.expenses_auth.exceptions;

import java.time.LocalDateTime;

public record ApiError(
        int status,
        String message,
        String path,
        LocalDateTime timestamp
) {}
