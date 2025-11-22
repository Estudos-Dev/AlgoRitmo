package com.aa.algoritmo.ports.in.api;

import com.aa.algoritmo.adapter.in.model.request.SalesRequest;
import com.aa.algoritmo.adapter.in.model.response.SalesResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ("/api/sales"))
public interface SalesManagementPort {
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Venda cadastrado com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro ao criar venda")
            }
    )
    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<SalesResponse> createSales(@RequestBody SalesRequest salesRequest);

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Vendas encontradas"),
                    @ApiResponse(responseCode ="404", description = "Nenhuma venda encontrada")
            }
    )
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<List<SalesResponse>> findAllSales(
            @RequestParam(required = false) Integer limit
    );

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro ao atualizar o produto")
            }
    )
    @PutMapping(
            value = "/update/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<SalesResponse> updateSales(@PathVariable Integer id, @RequestBody SalesRequest salesRequest);

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Produto removido com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro ao remover o produto")
            }
    )
    @DeleteMapping(
            value = "/delete/{id}"
    )
    ResponseEntity<Void> deleteSale(@PathVariable Integer id);
}


