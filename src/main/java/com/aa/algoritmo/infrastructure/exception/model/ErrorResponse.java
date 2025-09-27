package com.aa.algoritmo.infrastructure.exception.model;

import java.time.LocalDateTime;

public record ErrorResponse (LocalDateTime timestamp, int status, String message) {
}
