package com.aa.algoritmo.ports.in.api;

import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.in.model.response.ProductResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = ("/api/products"))
public interface ProductManagementPort {
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro ao criar o produto")
            }
    )
    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest);

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Produtos encontrados"),
                    @ApiResponse(responseCode ="404", description = "Nenhum produto encontrado")
            }
    )
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    ResponseEntity<List<ProductResponse>> findAllProducts();

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
    ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest);

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
    ResponseEntity<Void> deleteProduct(@PathVariable Integer id);
}
