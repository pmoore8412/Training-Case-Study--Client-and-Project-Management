package org.casestudy.clientprojectmanagement.Controllers;

import org.casestudy.clientprojectmanagement.Entities.Client;
import org.casestudy.clientprojectmanagement.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/new-client")
    public void addNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    @GetMapping("/list-all-clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

}
