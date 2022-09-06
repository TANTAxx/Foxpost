package com.foxpost.controller;

import com.foxpost.DTO.ParcelsDTO;
import com.foxpost.entity.Parcel;
import com.foxpost.service.ParcelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParcelsController {
    @Autowired
    private ParcelsService parcelsService;

    @GetMapping("/parcels")
    private List<Parcel> getAllParcels() {
        return parcelsService.findAllParcels();
    }

    @GetMapping("/parcelRecId/{receiverId}")
    private List<Parcel> getParcelToReceiverId(@PathVariable("receiverId") int receiverId) {
        return parcelsService.getParcelByReceiverId(receiverId);
    }

    @GetMapping("/parcelSenId/{senderId}")
    private List<Parcel> getParcelToSenderId(@PathVariable("senderId") int senderId) {
        return parcelsService.getParcelBySenderId(senderId);
    }

    @GetMapping("/parcel/{id}")
    private Parcel getParcel(@PathVariable("id") int id) {
        return parcelsService.getParcelById(id);
    }

    @DeleteMapping("/parcel/{id}")
    private void deleteParcel(@PathVariable("id") int id) {
        parcelsService.delete(id);
    }

    @PostMapping("/parcel")
    private Parcel saveParcel(@RequestBody ParcelsDTO parcelsDTO) {
        return parcelsService.saveOrUpdate(parcelsDTO);
    }

}
