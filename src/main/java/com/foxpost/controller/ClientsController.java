package com.foxpost.controller;

import com.foxpost.entity.Client;
import com.foxpost.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientsController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    private List<Client> getAllClients() {
        return clientService.findByAllClients();
    }

    @GetMapping("/client/{id}")
    private Client getClient(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }
    @PostMapping("/client")
    private int saveClient(@RequestBody Client client){
        clientService.saveOrUpdate(client);
        return client.getId();
    }
    @DeleteMapping("/client/{id}")
    private void deleteClient(@PathVariable("id") int id) {
        clientService.deleteClient(id);
    }

}
