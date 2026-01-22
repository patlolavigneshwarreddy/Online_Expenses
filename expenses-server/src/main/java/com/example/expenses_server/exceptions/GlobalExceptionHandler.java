package com.example.expenses_server.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.expenses_server.dto.ResponseErrorDto;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseErrorDto> handleValidationException(MethodArgumentNotValidException ex) {

		return buildError(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseErrorDto> handleJsonError(HttpMessageNotReadableException ex) {

		return buildError(HttpStatus.BAD_REQUEST, "Malformed JSON request");
	}

	/*
	 * =============================== Database Constraint Errors (400)
	 * ===============================
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ResponseErrorDto> handleDBError(DataIntegrityViolationException ex) {

		return buildError(HttpStatus.BAD_REQUEST, "Invalid data. Required fields may be missing.");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseErrorDto> handleGenericException(Exception ex) {

		return buildError(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error occurred");
	}

	private ResponseEntity<ResponseErrorDto> buildError(HttpStatus status, String message) {
		ResponseErrorDto error = new ResponseErrorDto(message, status.value());
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ResponseErrorDto> handleFeignException(FeignException ex) {

		return buildError(HttpStatus.SERVICE_UNAVAILABLE, "Category service is unavailable. Please try again later.");
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
