package org.casestudy.clientprojectmanagement.Services;

import org.casestudy.clientprojectmanagement.Entities.Client;
import org.casestudy.clientprojectmanagement.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client addNewClient(Client client) {
        Optional<Client> savedClient = Optional.ofNullable(clientRepository.findByClientName(client.getClientName()));
        if(savedClient.isPresent()) {
            throw new ResponseStatusException(HttpStatus.FOUND,
                    "Client with name " + client.getClientName() + " already exists");
        }
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll().stream().collect(Collectors.toList());
    }

}
