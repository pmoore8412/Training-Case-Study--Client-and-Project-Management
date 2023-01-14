package org.casestudy.clientprojectmanagement.Services;

import org.casestudy.clientprojectmanagement.Entities.AgreementFile;
import org.casestudy.clientprojectmanagement.Entities.Client;
import org.casestudy.clientprojectmanagement.Repositories.AgreementFileRepositories;
import org.casestudy.clientprojectmanagement.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AgreementFileRepositories agreementFileRepositories;

    public Client addNewClient(Client client) {
        Optional<Client> savedClient = Optional.ofNullable(clientRepository.findByClientName(client.getClientName()));
        if(savedClient.isPresent()) {
            throw new ResponseStatusException(HttpStatus.FOUND,
                    "Client with name " + client.getClientName() + " already exists");
        }

        return clientRepository.save(client);
    }

    public Client getClient(String id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "No client found with id: " + id));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll().stream().collect(Collectors.toList());
    }

    public Client updateClientDetails(Client client) {
        Optional<Client> updateClient = clientRepository.findById(client.getId());

        if(updateClient.isPresent()) {
            updateClient.get().setClientName(client.getClientName());
            updateClient.get().setClientDescription(client.getClientDescription());
            client = updateClient.get();
        }

        return clientRepository.save(client);
    }

}
