package com.foxpost.service;

import com.foxpost.entity.Client;
import com.foxpost.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {

    private ClientRepository clientRepository;

    public List<Client> findByAllClients() {
        log.info(" <-- Find all Clients");
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        log.info(" <-- Find One Client by ID: {}", id);
        Client client = clientRepository.findById(id).orElse(null);
        if (Objects.nonNull(client)) {
            log.info(" <-- Find Successfull");
            return client;
        } else {
            log.error(" <-- Cant Find One Client by ID: {}", id);
            return null;
        }
    }

    public void saveOrUpdate(Client client) {
        log.info(" <-- Save Client: {}", client);
        if (Objects.nonNull(client)) {
            clientRepository.save(client);
        } else {
            log.error(" <-- Can't Save Client: {}", client);
        }
        log.info(" <-- Save successfull: {} ", client);
    }

    //    public Clients getParcelBySenderId(Clients senderId) {
//        Optional<Clients> parcel = clientRepository.findBySenderId(senderId);
//        if(parcel.isPresent()){
//            return parcel.get();
//        }else {
//            log.error("");
//            return null;
//        }
//    }
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
