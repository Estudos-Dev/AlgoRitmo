package com.aa.algoritmo.adapter.in.model.request;

import java.time.LocalDateTime;
import java.util.List;

public record SalesRequest (
        Integer sellerId,
        Integer clientId,
        LocalDateTime date,
        List<SalesItemRequest> items) {
}