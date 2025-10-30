package com.aa.algoritmo.adapter.in.model.response;

import java.time.LocalDateTime;

public record SellerResponse(String name, String email, LocalDateTime createdAt) {
}
