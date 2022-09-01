package com.foxpost.service;

import com.foxpost.DTO.ParcelsDTO;
import com.foxpost.entity.Parcels;
import com.foxpost.repository.ParcelsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ParcelsService {

    private ClientService clientService;

    private ParcelsRepository parcelsRepository;


    //Összes Csomag
    public List<Parcels> findAllParcels() {
        log.info(" <-- Find all Parcels: {}");
//        log.error(" <-- Can't Find All Parcels");
        return parcelsRepository.findAll();
    }

    public Parcels saveOrUpdate(ParcelsDTO parcelsDTO) {
        log.info(" <-- In Save Parcel: {}", parcelsDTO);
//        log.error(" <-- Can't Save Parcel: {}", parcelsDTO);
        String parcelNO = parcelsDTO.getParcelNo();
        Parcels parcels = new Parcels(
                clientService.getClientById(parcelsDTO.getReceiverId()),
                clientService.getClientById(parcelsDTO.getSenderId()),
                parcelNO
        );
        log.info(" <-- End Save Parcel: {}", parcelsDTO);
        return parcelsRepository.save(parcels);
    }

    //TODO Trackingből  Parcel Id-ra
// ,
    public void delete(int id) {
        log.info(" <-- Delete Parcel: {}", id);
//        log.error(" <-- Can't Delete Parcel: {}", id);
        parcelsRepository.deleteById(id);
        log.info(" <-- Delete End From Parcels: {}", id);
    }

    public Parcels getParcelById(int id) {
        log.info(" <-- Find Parcel By ID : {}", id);
//        log.error(" <-- Can't Find Parcel By Id: {}", id);
        return parcelsRepository.findById(id).orElse(null);
    }

    public List<Parcels> getParcelBySenderId(int senderId) {
        log.info(" <-- Find Parcel By Sender ID: {}", senderId);
//        log.error(" <-- Can't Find Parcel By Sender ID: {}", senderId);
        return parcelsRepository.findAllBySenderId(clientService.getClientById(senderId));
    }

    public List<Parcels> getParcelByReceiverId(int receiverId) {
        log.info(" <-- Find Parcel By Receiver ID: {}", receiverId);
//        log.error(" <-- Can't Find Parcel By Receiver ID: {}", receiverId);
        return parcelsRepository.findAllByReceiverId(clientService.getClientById(receiverId));
    }

}