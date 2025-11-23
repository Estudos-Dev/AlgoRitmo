package com.aa.algoritmo.adapter.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.ClientRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.ClientEntity;
import com.aa.algoritmo.adapter.out.persistence.repository.ClientRepository;
import com.aa.algoritmo.adapter.service.mapper.ClientMapper;
import com.aa.algoritmo.ports.out.persistence.ClientPersistencePort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientPersistenceAdapter implements ClientPersistencePort {
    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    private final ClientRepository clientRepository;

    public ClientPersistenceAdapter(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientEntity> findAllClients(Integer limit) {
        return clientRepository.findAllLimited(limit);
    }

    @Override
    public ClientEntity createClient(ClientRequest clientRequest) {
        ClientEntity entity = clientMapper.requestToEntity(clientRequest);
        return clientRepository.save(entity);
    }

    @Override
    public ClientEntity updateClient(Integer id, ClientRequest clientRequest) {
        ClientEntity entity = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clientMapper.updateEntityFromRequest(clientRequest, entity);
        return clientRepository.save(entity);
    }

    @Override
    public void deleteClient(Integer id) {
        ClientEntity entity = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clientRepository.delete(entity);
    }

    @Override
    public ClientEntity findById(Integer integer) {
        return clientRepository.findById(integer)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id " + integer));
    }
}