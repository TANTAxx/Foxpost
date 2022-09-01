package com.foxpost.controller;

import com.foxpost.entity.Clients;
import com.foxpost.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientsController {
    @Autowired
    private ClientService clientService;

    //    Ügyfelek lekérdezése
    @GetMapping("/clients")
    private List<Clients> getAllClients() {
        return clientService.findByAllClients();
    }

    @GetMapping("/client/{id}")
    private Clients getClient(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }
    @PostMapping("/clients")
    private int saveClients(@RequestBody Clients clients){
        clientService.saveOrUpdate(clients);
        return clients.getId();
    }
    @DeleteMapping("/client/{id}")
    private void deleteClient(@PathVariable("id") int id) {
        clientService.deleteClient(id);
    }




}
