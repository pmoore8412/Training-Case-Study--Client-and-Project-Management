package org.casestudy.clientprojectmanagement.Services;

import org.casestudy.clientprojectmanagement.Entities.Client;
import org.casestudy.clientprojectmanagement.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void addNewClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll().stream().collect(Collectors.toList());
    }

}
