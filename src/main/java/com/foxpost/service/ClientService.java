package com.foxpost.service;

import com.foxpost.entity.Clients;
import com.foxpost.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
    private ClientRepository clientRepository;

    public List<Clients> findByAllClients() {
        log.info(" <-- Find all Clients");
//        log.error(" <-- Can't Find all Clients");
        return clientRepository.findAll();
    }

    public Clients getClientById(int id) {
        log.info(" <-- Find One Client by ID: {}", id);
//        log.error(" <-- Cant Find One Client by ID: {}", id);
        return clientRepository.findById(id).orElse(null);
    }
    public void saveOrUpdate(Clients clients) {
        log.info(" <-- in Save Client: {}", clients);
//        log.error(" <-- Can't Save Client: {}", clients);
        clientRepository.save(clients);
        log.info(" <-- End Save Client: {}");
    }
    public void deleteClient(int id) {
        log.info(" <-- in Delete Client: {}", id);
//        log.error(" <-- Can't Delete Client: {}", id);
        clientRepository.deleteById(id);
        log.info(" <-- End Delete Client: {}");
    }

}
