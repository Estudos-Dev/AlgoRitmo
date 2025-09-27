package com.aa.algoritmo.infrastructure.exception.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {
    USER_NOT_FOUND("Usuário não encontrado", HttpStatus.NOT_FOUND);
    private final String message;
    private final HttpStatus status;

    Error(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
