package com.example.expenses_server.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.expenses_server.dto.ResponseErrorDto;

import feign.FeignException;

public class GlobalExceptionHandlerTest {

    GlobalExceptionHandler handler = new GlobalExceptionHandler();

//    @Test
//    void handleValidationException_returnsBadRequest() {
//        ResponseEntity<ResponseErrorDto> resp = handler.handleValidationException(new MethodArgumentNotValidException(null, null));
//        assertThat(resp.getStatusCode().value()).isEqualTo(400);
//        assertThat(resp.getBody().getMessage()).isNotBlank();
//    }

//    @Test
//    void handleJsonError_returnsBadRequest() {
//        ResponseEntity<ResponseErrorDto> resp = handler.handleJsonError(new HttpMessageNotReadableException("err"));
//        assertThat(resp.getStatusCode().value()).isEqualTo(400);
//        assertThat(resp.getBody().getMessage()).isEqualTo("Malformed JSON request");
//    }

    @Test
    void handleDBError_returnsBadRequest() {
        ResponseEntity<ResponseErrorDto> resp = handler.handleDBError(new DataIntegrityViolationException("err"));
        assertThat(resp.getStatusCode().value()).isEqualTo(400);
    }

//    @Test
//    void handleFeignException_returnsServiceUnavailable() {
//        ResponseEntity<ResponseErrorDto> resp = handler.handleFeignException(FeignException.errorStatus("x", null));
//        assertThat(resp.getStatusCode().value()).isEqualTo(503);
//        assertThat(resp.getBody().getMessage()).contains("Category service is unavailable");
//    }

    @Test
    void handleGenericException_returnsInternalServerError() {
        ResponseEntity<ResponseErrorDto> resp = handler.handleGenericException(new Exception("boom"));
        assertThat(resp.getStatusCode().value()).isEqualTo(500);
    }
}
