package com.foxpost.service;

import com.foxpost.entity.Clients;
import com.foxpost.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
    private ClientRepository clientRepository;

    public List<Clients> findByAllClients() {
        log.info(" <-- Find all Clients");
        return clientRepository.findAll();
    }

    public Clients getClientById(int id) {
        log.info(" <-- Find One Client by ID: {}", id);
        Clients client = clientRepository.findById(id).orElse(null);
        if (Objects.nonNull(client)) {
            return client;
        } else {
            log.error(" <-- Cant Find One Client by ID: {}", id);
            return null;
        }
    }

    public void saveOrUpdate(Clients clients) {
        log.info(" <-- Save Client: {}", clients);
        if (Objects.nonNull(clients)) {
            clientRepository.save(clients);
        } else {
            log.error(" <-- Can't Save Client: {}", clients);
        }
        log.info(" <-- Save successfull: {} ", clients);
    }

    public Clients getParcelBySenderId(Clients senderId) {
        Optional<Clients> parcel = clientRepository.findBySenderId(senderId);
        if(parcel.isPresent()){
            return parcel.get();
        }else {
            log.error("");
            return null;
        }
    }
    public void deleteClient(int id) {
        log.info(" <-- in Delete Client: {}", id);
        if (Objects.nonNull(id)) {
            clientRepository.deleteById(id);
        } else {
            log.error(" <-- Can't Delete from Client: {}", id);
        }
        log.info("Delete successfull: {}", id);
    }

}
