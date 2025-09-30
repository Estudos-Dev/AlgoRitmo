package com.aa.algoritmo.ports.in.api;

import com.aa.algoritmo.adapter.in.model.request.VendedorRequest;
import com.aa.algoritmo.adapter.in.model.response.VendedorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


//http://localhost:8080/swagger-ui/index.html#/
@Tag(name = "Gerenciamento de Vendedor",
        description = "API para gerenciar vendedores")
@RequestMapping(value = ("/api/user"))
public interface VendedorManagementPort {

    @Operation(summary = "Cadastro de vendedor")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Vendedor cadastrado com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro ao cadastrar vendedor")
            })
    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<VendedorResponse> createUser(@RequestBody VendedorRequest vendedorRequest);

    @Operation(summary = "Busca por id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            })
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<VendedorResponse> getUserById(@PathVariable UUID id);

}
