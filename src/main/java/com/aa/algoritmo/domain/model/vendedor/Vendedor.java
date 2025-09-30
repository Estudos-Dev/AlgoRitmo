package com.aa.algoritmo.domain.model.vendedor;

import java.time.LocalDateTime;
import java.util.UUID;

public record Vendedor(UUID id, String nome, String email, LocalDateTime criadoEm) {
}
