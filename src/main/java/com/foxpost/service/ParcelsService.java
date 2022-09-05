package com.foxpost.service;

import com.foxpost.DTO.ParcelsDTO;
import com.foxpost.entity.Clients;
import com.foxpost.entity.Parcels;
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


    public List<Parcels> findAllParcels() {
        log.info(" <-- Find all Parcels: {}");
        return parcelsRepository.findAll();
    }

    public Parcels saveOrUpdate(ParcelsDTO parcelsDTO) {
        log.info(" <-- In Save Parcel: {}", parcelsDTO);
        String parcelNO = parcelsDTO.getParcelNo();
        Parcels parcel = new Parcels(
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

    public Parcels getParcelById(int id) {
        log.info(" <-- Find Parcel By ID : {}", id);
        Parcels parcel = parcelsRepository.findById(id).orElse(null);
        if (Objects.nonNull(parcel)) {
            log.info(" <-- Successfull");
            return parcel;
        } else {
            log.error(" <-- Can't Find Parcel By Id: {}", id);
            return null;
        }
    }
//return parcelsRepository.findById(senderId).orElse(null);
//    public Parcels getParcelBySenId(int senderId) {
//        log.info(" <-- Find Parcel By ID : {}", senderId);
//        Parcels parcel = parcelsRepository.findById(senderId).orElse(null);
//        if(Objects.nonNull(parcel)){
//            return parcel;
//        }else {
//            log.error("Not find Parcel to senderId");
//            return null;
//        }
//    }

    public Parcels getParcelByNumber(String parcelNumber) {
        log.info("Find Parcel By Parcel Number");
        Optional<Parcels> parcel = parcelsRepository.findByParcelNo(parcelNumber);
        if (parcel.isPresent()) {
            return parcel.get();
        } else {
            log.error("Parcel not found!");
            return null;
        }
    }

    public Parcels findBySenderId(Clients senderId){
        Clients clients = clientService.getParcelBySenderId(senderId);
        return parcelsRepository.findBySenderId(clients);
    }
//    public Parcels getParcelBySenderId(Clients senderId) {
//        Optional<Parcels> parcel = parcelsRepository.findBySenderId(senderId);
//        if(parcel.isPresent()){
//            return parcel.get();
//        }else {
//            log.error("");
//            return null;
//        }
//    }


//    public List<Parcels> getParcelByReceiverId(int receiverId) {
//        log.info(" <-- Find Parcel By Receiver ID: {}", receiverId);
//        Clients client = clientService.getClientById(receiverId);
//        if (Objects.nonNull(client)) {
//            return parcelsRepository.findByReceiverId(client);
//        } else {
//            log.error(" <-- Can't Find Parcel By Receiver ID: {}", receiverId);
//            return null;
//        }
//    }


}