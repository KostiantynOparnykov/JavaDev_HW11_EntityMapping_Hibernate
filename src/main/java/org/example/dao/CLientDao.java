package org.example.dao;

import org.example.entities.Client;

import java.util.List;

public interface CLientDao {
    Long createClient(Client client);

    Client getClientById(Long clientId);

    List<Client> getAllClients();

    boolean updateClient(Client client);

    boolean deleteClient(Client client);

    boolean deleteClientById(Long clientId);
}
