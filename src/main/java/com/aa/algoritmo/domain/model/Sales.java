package com.aa.algoritmo.domain.model;

import java.time.LocalDateTime;

public record Sales (
        Integer id,
        Integer sellerId,
        Integer clientId,
        LocalDateTime date) {
}