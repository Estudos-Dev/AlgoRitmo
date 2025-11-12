package com.aa.algoritmo.domain.usecases;

import com.aa.algoritmo.adapter.in.model.request.ClientRequest;
import com.aa.algoritmo.domain.model.client.Client;

import java.util.List;

public interface ClientUseCase {
    List<Client> findAllClients();
    Client createClient(ClientRequest clientRequest);
    Client updateClient(Integer id, ClientRequest clientRequest);
    void deleteClient(Integer id);
}
