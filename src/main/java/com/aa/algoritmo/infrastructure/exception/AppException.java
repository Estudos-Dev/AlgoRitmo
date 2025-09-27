package com.aa.algoritmo.infrastructure.exception;

import com.aa.algoritmo.infrastructure.exception.model.Error;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException {

    private final Error error;

    public AppException(Error error) {
        super(error.getMessage());
        this.error = error;
    }

    public AppException(Error error, Object... args) {
        super(String.format(error.getMessage(), args));
        this.error = error;
    }
}
