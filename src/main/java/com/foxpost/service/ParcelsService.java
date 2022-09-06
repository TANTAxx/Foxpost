package com.foxpost.service;

import com.foxpost.DTO.ParcelsDTO;
import com.foxpost.entity.Client;
import com.foxpost.entity.Parcel;
import com.foxpost.repository.ParcelsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ParcelsService {

    private ClientService clientService;

    private ParcelsRepository parcelsRepository;


    public List<Parcel> findAllParcels() {
        log.info(" <-- Find all Parcels: {}");
        return parcelsRepository.findAll();
    }

    public Parcel saveOrUpdate(ParcelsDTO parcelsDTO) {
        log.info(" <-- In Save Parcel: {}", parcelsDTO);
        String parcelNO = parcelsDTO.getParcelNo();
        Parcel parcel = new Parcel(
                clientService.getClientById(parcelsDTO.getReceiverId()),
                clientService.getClientById(parcelsDTO.getSenderId()),
                parcelNO
        );
        if (Objects.nonNull(parcel)) {
            return parcelsRepository.save(parcel);
        } else {
            log.error(" <-- Can't Save Parcel: {}", parcelsDTO);
            return null;
        }
    }


    public void delete(int id) {
        log.info(" <-- Delete Parcel: {}", id);
        if (Objects.nonNull(id)) {
            parcelsRepository.deleteById(id);
        } else {
            log.error(" <-- Can't Delete Parcel: {}", id);
        }
    }

    public Parcel getParcelById(int id) {
        log.info(" <-- Find Parcel By ID : {}", id);
        Parcel parcel = parcelsRepository.findById(id).orElse(null);
        if (Objects.nonNull(parcel)) {
            log.info(" <-- Successfull");
            return parcel;
        } else {
            log.error(" <-- Can't Find Parcel By Id: {}", id);
            return null;
        }
    }

    public Parcel getParcelByNumber(String parcelNumber) {
        log.info("Find Parcel By Parcel Number");
        Optional<Parcel> parcel = parcelsRepository.findByParcelNo(parcelNumber);
        if (parcel.isPresent()) {
            return parcel.get();
        } else {
            log.error("Parcel not found!");
            return null;
        }
    }

    public List<Parcel> getParcelBySenderId(int senderId) {
        log.info(" <-- Find Parcel By Sender ID: {}", senderId);
        Client client = clientService.getClientById(senderId);
        if (Objects.nonNull(client)) {
            return parcelsRepository.findAllByReceiverId(client);
        } else {
            log.error(" <-- Can't Find Parcel By senderId: {} ",senderId);
            return null;
        }
    }


    public List<Parcel> getParcelByReceiverId(int receiverId) {
        log.info(" <-- Find Parcel By Receiver ID: {}", receiverId);
        Client client = clientService.getClientById(receiverId);
        if (Objects.nonNull(client)) {
            return parcelsRepository.findAllByReceiverId(client);
        } else {
            log.error(" <-- Can't Find Parcel By Receiver ID: {}", receiverId);
            return null;
        }
    }


}