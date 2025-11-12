package com.aa.algoritmo.domain.usecases.impl;

import com.aa.algoritmo.adapter.in.model.request.ClientRequest;
import com.aa.algoritmo.adapter.service.mapper.ClientMapper;
import com.aa.algoritmo.domain.model.client.Client;
import com.aa.algoritmo.domain.usecases.ClientUseCase;
import com.aa.algoritmo.ports.out.persistence.ClientPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientImpl implements ClientUseCase {
    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    private final ClientPersistencePort clientPersistencePort;

    public ClientImpl(ClientPersistencePort clientPersistencePort) {
        this.clientPersistencePort = clientPersistencePort;
    }

    @Override
    public List<Client> findAllClients() {
        return clientMapper.toModelList(clientPersistencePort.findAllClients());
    }

    @Override
    public Client createClient(ClientRequest clientRequest) {
        return clientMapper.toModel(clientPersistencePort.createClient(clientRequest));
    }

    @Override
    public Client updateClient(Integer id, ClientRequest clientRequest) {
        return clientMapper.toModel(clientPersistencePort.updateClient(id, clientRequest));
    }

    @Override
    public void deleteClient(Integer id) {
        clientPersistencePort.deleteClient(id);
    }
}
