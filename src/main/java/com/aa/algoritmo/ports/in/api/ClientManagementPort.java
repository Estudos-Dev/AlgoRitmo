package com.aa.algoritmo.ports.in.api;

import com.aa.algoritmo.adapter.in.model.request.ClientRequest;
import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.in.model.response.ClientResponse;
import com.aa.algoritmo.adapter.in.model.response.ProductResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ("/api/clients"))
public interface ClientManagementPort {
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro ao criar o cliente")
            }
    )
    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest);

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Clientes encontrados"),
                    @ApiResponse(responseCode ="404", description = "Nenhum cliente encontrado")
            }
    )
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<List<ClientResponse>> findAllClients();

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro ao atualizar o Cliente")
            }
    )
    @PutMapping(
            value = "/update/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<ClientResponse> updateClient(@PathVariable Integer id, @RequestBody ClientRequest clientRequest);

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cliente removido com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro ao remover o Cliente")
            }
    )
    @DeleteMapping(
            value = "/delete/{id}"
    )
    ResponseEntity<Void> deleteClient(@PathVariable Integer id);
}
