package com.aa.algoritmo.ports.in.api;

import com.aa.algoritmo.adapter.in.model.request.SellerRequest;
import com.aa.algoritmo.adapter.in.model.response.SellerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//http://localhost:8080/swagger-ui/index.html#/
@Tag(name = "Gerenciamento de Seller",
        description = "API para gerenciar vendedores")
@RequestMapping(value = ("/api/sellers"))
public interface SellerManagementPort {

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Vendedores encontrados"),
                    @ApiResponse(responseCode = "404", description = "Nenhum vendedor encontrado")
            }
    )
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<List<SellerResponse>> findAllSellers(
            @RequestParam(required = false) Integer limit
    );

    @Operation(summary = "Cadastro de vendedor")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Seller cadastrado com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro ao cadastrar vendedor")
            })
    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SellerResponse> createUser(@RequestBody SellerRequest sellerRequest);

    @Operation(summary = "Apagar de vendedor")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Vendedor excluído com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro ao excluir vendedor")
            })
    @DeleteMapping(
            value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteUserById(@PathVariable int id);

    @Operation(summary = "Busca por id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
            })
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SellerResponse> getUserById(@PathVariable int id);

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Vendedor atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Vendendor não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro ao atualizar o Vendedor")
            }
    )
    @PutMapping(
            value = "/update/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<SellerResponse> updateClient(@PathVariable Integer id, @RequestBody SellerRequest sellerRequest);
}