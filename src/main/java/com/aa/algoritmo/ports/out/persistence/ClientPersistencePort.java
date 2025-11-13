package com.aa.algoritmo.ports.out.persistence;

import com.aa.algoritmo.adapter.in.model.request.ClientRequest;
import com.aa.algoritmo.adapter.out.persistence.entity.ClientEntity;

import java.util.List;

public interface ClientPersistencePort {
    List<ClientEntity> findAllClients();
    ClientEntity createClient(ClientRequest productRequest);
    ClientEntity updateClient(Integer id, ClientRequest productRequest);
    void deleteClient(Integer id);

    ClientEntity findById(Integer integer);
}
