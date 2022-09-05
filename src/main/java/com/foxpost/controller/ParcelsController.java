package com.foxpost.controller;

import com.foxpost.DTO.ParcelsDTO;
import com.foxpost.entity.Clients;
import com.foxpost.entity.Parcels;
import com.foxpost.service.ParcelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ParcelsController {
    @Autowired
    private ParcelsService parcelsService;

    @GetMapping("/parcels")
    private List<Parcels> getAllParcels() {
        return parcelsService.findAllParcels();
    }

//        Csomagok ügyfelenként(címzett) receiveredId
//    @GetMapping("/parcelRecId/{receiverId}")
//    private List<Parcels> getParcelToReceiverId(@PathVariable("receiverId") int receiverId) {
//        return parcelsService.getParcelByReceiverId(receiverId);
//    }

    //    Csomagok ügyfelenként (feladó) senderId
    @GetMapping("/parcelSenId/{senderId}")
    private Parcels getParcelToSenderId(@PathVariable("senderId") Clients senderId) {
        return parcelsService.findBySenderId(senderId);
    }
    @GetMapping("/parcel/{id}")
    private Parcels getParcel(@PathVariable("id") int id) {
        return parcelsService.getParcelById(id);
    }

    @DeleteMapping("/parcel/{id}")
    private void deleteParcel(@PathVariable("id") int id) {
        parcelsService.delete(id);
    }

    @PostMapping("/parcels")
    private Parcels saveParcel(@RequestBody ParcelsDTO parcelsDTO) {
        return parcelsService.saveOrUpdate(parcelsDTO);
    }

}
