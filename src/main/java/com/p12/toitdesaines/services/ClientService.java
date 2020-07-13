package com.p12.toitdesaines.services;


import com.p12.toitdesaines.DTO.ClientDTO;
import com.p12.toitdesaines.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClients();

   Client getClient (Long id);

    Client createClient(ClientDTO clientDTO);

    void deleteClient(Long id);
}

