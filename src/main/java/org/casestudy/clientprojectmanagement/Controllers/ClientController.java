package org.casestudy.clientprojectmanagement.Controllers;

import org.casestudy.clientprojectmanagement.Entities.Client;
import org.casestudy.clientprojectmanagement.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/new-client")
    public Client addNewClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable(name = "id") String id) {
        return clientService.getClient(id);
    }

    @GetMapping("/list-all-clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PutMapping("/update-client/{id}")
    public Client updateClientDetails(@RequestBody Client client) {
        return clientService.updateClientDetails(client);
    }

}
