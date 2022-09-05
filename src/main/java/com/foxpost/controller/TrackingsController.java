package com.foxpost.controller;

import com.foxpost.DTO.TrackingDTO;
import com.foxpost.entity.Parcels;
import com.foxpost.entity.Trackings;
import com.foxpost.service.TrackingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackingsController {
    @Autowired
    private TrackingsService trackingsService;

    @GetMapping("/trackings")
    private List<Trackings> getAllTracking() {
        return trackingsService.findAllTrackings();
    }

    @GetMapping("/tracking/{id}")
    private Trackings getTracking(@PathVariable("id") int id) {
        return trackingsService.getTrackingById(id);
    }

    @DeleteMapping("/tracking/{id}")
    private void deleteTracking(@PathVariable("id") int id) {
        trackingsService.deleteTrackings(id);
    }

    @PostMapping("/trackings")
    private Trackings saveTracking(@RequestBody TrackingDTO trackingDTO) {
        return trackingsService.saveOrUpdate(trackingDTO);
    }

    @GetMapping("/trackingsParcelNo/{parcelNo}")
    private List<Trackings> getAllTrackingsByParcelId(@PathVariable("parcelNo") String parcelNumber) {
        return trackingsService.findAllTrackingsByParcelNumber(parcelNumber);
    }
}
