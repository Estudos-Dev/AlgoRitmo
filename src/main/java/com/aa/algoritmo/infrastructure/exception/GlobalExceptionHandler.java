package com.aa.algoritmo.infrastructure.exception;

import com.aa.algoritmo.infrastructure.exception.model.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ExceptionResponse> handleAppException(AppException appException) {
        return handleAppException(appException, appException.getError().getStatus());
    }

    private ResponseEntity<ExceptionResponse> handleAppException(Exception exception, HttpStatus status) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(status).body(new ExceptionResponse(exception.getMessage(), status.value()));
    }
}
