package com.foxpost.controller;

import com.foxpost.DTO.ParcelsDTO;
import com.foxpost.entity.Parcels;
import com.foxpost.service.ParcelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParcelsController {
    @Autowired
    private ParcelsService parcelsService;


//    Csomagokhoz esemény lista??????????????


    //    Csomagok lekérdezése
    @GetMapping("/parcels")
    private List<Parcels> getAllParcels() {
        return parcelsService.findAllParcels();
    }

    //    Csomagok ügyfelenként(címzett) receiveredId
    @GetMapping("/parcelRecId/{receiverId}")
    private List<Parcels> getParcelToReceiverId(@PathVariable("receiverId") int receiverId) {
        return parcelsService.getParcelByReceiverId(receiverId);
    }

    //    Csomagok ügyfelenként (feladó) senderId
    @GetMapping("/parcelSenId/{senderId}")
    private List<Parcels> getParcelToSenderId(@PathVariable("senderId") int senderId) {
        return parcelsService.getParcelBySenderId(senderId);
    }

    @GetMapping("/parcel/{id}")
    private Parcels getParcel(@PathVariable("id") int id) {
        return parcelsService.getParcelById(id);
    }

    @DeleteMapping("/parcel/{id}")
    private void deleteParcel(@PathVariable("id") int id) {
        parcelsService.delete(id);
    }

    /*le mentésnél a csomag számát null értékbe kapom vissza ->
      parcelsDto-ba létrekellet hozni egy változot majd azt berakni a save-be hogy Stringet is le tudjon menteni!*/
    @PostMapping("/parcels")
    private Parcels saveParcel(@RequestBody ParcelsDTO parcelsDTO) {
        return parcelsService.saveOrUpdate(parcelsDTO);
    }

//    @GetMapping("/parcel/{senderId}")
//    private Parcels getSenderIdParcel(@PathVariable("senderId") Clients senderId) {
//        return parcelsService.getParcelBySenderId(senderId.getId());
//    }

}
