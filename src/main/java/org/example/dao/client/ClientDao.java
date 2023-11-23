package org.example.dao.client;

import org.example.entities.Client;

import java.util.List;

public interface ClientDao {
    Long createClient(Client client);

    Client getClientById(Long clientId);

    List<Client> getAllClients();

    boolean updateClient(Client client);

    boolean deleteClient(Client client);

    boolean deleteClientById(Long clientId);
}
