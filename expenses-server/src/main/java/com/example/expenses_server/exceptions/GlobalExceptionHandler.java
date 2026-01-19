package com.example.expenses_server.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.expenses_server.dto.ResponseErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({
        HttpMessageNotReadableException.class,
        MissingServletRequestParameterException.class,
        MissingRequestHeaderException.class,
        MethodArgumentTypeMismatchException.class,
        ResourceNotFoundException.class
        
})
public ResponseEntity<ResponseErrorDto> handleBadRequest(Exception ex) {
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ResponseErrorDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
}
	
}
