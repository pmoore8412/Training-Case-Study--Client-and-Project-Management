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
    public Client updateClientDetails(@PathVariable(name = "id") String id, @RequestBody Client client) {
        return clientService.updateClientDetails(id, client);
    }

    @DeleteMapping("/remove-client/{id}")
    public void removeClient(@PathVariable(name = "id") String id) {
        clientService.removeClient(id);
    }
}
