package com.aa.algoritmo.ports.in.api;

import com.aa.algoritmo.adapter.in.model.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
//http://localhost:8080/swagger-ui/index.html#/
@Tag(name = "Gerenciamento de usuários",
        description = "API para gerenciar usuários")
@RequestMapping(value = ("/api/user"))
public interface UserManagementPort {

    @Operation(summary = "Busca por id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            })
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UserResponse> getUserById(@PathVariable UUID id);

}
