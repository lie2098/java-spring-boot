package com.lye.restdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(StudentNotFoundException ex) {
        return getErrorResponseResponseEntity(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return getErrorResponseResponseEntity(HttpStatus.BAD_REQUEST, ex);
    }

    private static ResponseEntity<ErrorResponse> getErrorResponseResponseEntity(HttpStatus httpStatus, Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(httpStatus.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
