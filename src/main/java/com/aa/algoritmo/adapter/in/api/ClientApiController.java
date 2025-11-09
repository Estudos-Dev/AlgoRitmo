package com.aa.algoritmo.adapter.in.api;

import com.aa.algoritmo.adapter.in.model.request.ClientRequest;
import com.aa.algoritmo.adapter.in.model.request.ProductRequest;
import com.aa.algoritmo.adapter.in.model.response.ClientResponse;
import com.aa.algoritmo.adapter.in.model.response.ProductResponse;
import com.aa.algoritmo.adapter.service.mapper.ClientMapper;
import com.aa.algoritmo.domain.usecases.ClientUseCase;
import com.aa.algoritmo.ports.in.api.ClientManagementPort;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientApiController implements ClientManagementPort {
    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    private final ClientUseCase clientUseCase;

    public ClientApiController(ClientUseCase clientUseCase) {
        this.clientUseCase = clientUseCase;
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findAllClients() {
        return ResponseEntity.ok(clientMapper.toResponseList(clientUseCase.findAllClients()));
    }

    @Override
    public ResponseEntity<ClientResponse> createClient(ClientRequest clientRequest) {

        return ResponseEntity.ok(clientMapper.toResponse(clientUseCase.createClient(clientRequest)));
    }

    @Override
    public ResponseEntity<ClientResponse> updateClient(Integer id, ClientRequest clientRequest) {
        return ResponseEntity.ok(clientMapper.toResponse(clientUseCase.updateClient(id, clientRequest)));
    }

    @Override
    public ResponseEntity<Void> deleteClient(Integer id) {
        clientUseCase.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
