package com.foxpost.service;

import com.foxpost.DTO.TrackingDTO;
import com.foxpost.entity.Parcels;
import com.foxpost.entity.Trackings;
import com.foxpost.repository.TrackingsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TrackingsService {
    private ParcelsService parcelsService;
    private EventsService eventsService;
    private TrackingsRepository trackingsRepository;

    public List<Trackings> findAllTrackings() {
        log.info("Find all Trackings");
        return trackingsRepository.findAll();
    }

    public List<Trackings> findAllTrackingsByParcelId(Parcels parcelId) {
        log.info("Find all Trackings");
        return trackingsRepository.findAllByParcelId(parcelsService.getParcelById(parcelId.getId()));
    }

    public List<Parcels> getAllParcelsToOneTrack() {
        return parcelsService.findAllParcels();
    }

    public Trackings saveOrUpdate(TrackingDTO trackingDTO) {
        log.info("in save Trackings --> {}", trackingDTO);
        log.error("In save Trackings ERROR");
        LocalDate eventDate = trackingDTO.getEventDate();
        Trackings trackings = new Trackings(
                eventsService.getEventById(trackingDTO.getEventId()),
                parcelsService.getParcelById(trackingDTO.getParcelId()),
                eventDate
        );
        log.info("save end Trackings --> {}", trackingDTO);
        return trackingsRepository.save(trackings);

    }

    public void deleteTrackings(int id) {
        log.info("delete from Trackings -> {}", id);
        trackingsRepository.deleteById(id);
        log.info("delete from Trackings END -> {}", id);
    }

    public Trackings getTrackingById(int id) {
        log.info("Tracking By ID -> {}", id);
        return trackingsRepository.findById(id).orElse(null);
    }
}
