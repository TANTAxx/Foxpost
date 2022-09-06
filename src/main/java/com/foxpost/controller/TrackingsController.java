package com.foxpost.controller;

import com.foxpost.DTO.TrackingDTO;
import com.foxpost.entity.Tracking;
import com.foxpost.service.TrackingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackingsController {
    @Autowired
    private TrackingsService trackingsService;

    @GetMapping("/trackings")
    private List<Tracking> getAllTracking() {
        return trackingsService.findAllTrackings();
    }

    @GetMapping("/tracking/{id}")
    private Tracking getTracking(@PathVariable("id") int id) {
        return trackingsService.getTrackingById(id);
    }

    @DeleteMapping("/tracking/{id}")
    private void deleteTracking(@PathVariable("id") int id) {
        trackingsService.deleteTrackings(id);
    }

    @PostMapping("/tracking")
    private Tracking saveTracking(@RequestBody TrackingDTO trackingDTO) {
        return trackingsService.saveOrUpdate(trackingDTO);
    }

    @GetMapping("/trackingsParcelNo/{parcelNo}")
    private List<Tracking> getAllTrackingsByParcelNo(@PathVariable("parcelNo") String parcelNumber) {
        return trackingsService.findAllTrackingsByParcelNumber(parcelNumber);
    }
}
