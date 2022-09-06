package com.foxpost.service;

import com.foxpost.DTO.TrackingDTO;
import com.foxpost.entity.Parcel;
import com.foxpost.entity.Tracking;
import com.foxpost.repository.TrackingsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class TrackingsService {
    private ParcelsService parcelsService;
    private EventsService eventsService;
    private TrackingsRepository trackingsRepository;

    public List<Tracking> findAllTrackings() {
        log.info(" <-- Find all Trackings");
      List  <Tracking> trackings = trackingsRepository.findAll();
        if(Objects.nonNull(trackings)){
            log.info(" <-- Find Successfull");
            return trackingsRepository.findAll();
        }else {
            log.error(" <-- Not find ERROR");
            return null;
        }

    }

    public List<Tracking> findAllTrackingsByParcelNumber(String parcelNumber) {
        log.info(" <-- Find all Trackings");
        Parcel parcel = parcelsService.getParcelByNumber(parcelNumber);
        if (Objects.nonNull(parcel)) {
            return trackingsRepository.findAllByParcelId(parcel);
        } else {
            log.error("Get in Tracks Parcel not Found");
            return null;
        }
    }

    public List<Parcel> getAllParcelsToOneTrack() {
        return parcelsService.findAllParcels();
    }

    public Tracking saveOrUpdate(TrackingDTO trackingDTO) {
        log.info(" <-- in save Trackings --> {}", trackingDTO);
        LocalDate eventDate = trackingDTO.getEventDate();
        Tracking tracking = new Tracking(
                eventsService.getEventById(trackingDTO.getEventId()),
                parcelsService.getParcelById(trackingDTO.getParcelId()),
                eventDate
        );
        if (Objects.nonNull(tracking)) {
            return trackingsRepository.save(tracking);
        } else {
            log.error("In save Trackings ERROR");
            return null;
        }


    }

    public void deleteTrackings(int id) {
        log.info(" <-- delete from Trackings -> {}", id);
        if (Objects.nonNull(id)) {
            trackingsRepository.deleteById(id);
        }else {
            log.error(" <-- Can't Delete from Trackings: {}", id);
        }
    }

    public Tracking getTrackingById(int id) {
        log.info(" <-- Find Tracking By ID -> {}", id);
        Tracking track = trackingsRepository.findById(id).orElse(null);
        if(Objects.nonNull(track)){
            return track;
        }else {
            log.error(" <-- Can't Find track By Id: {}", id);
            return null;
        }
    }
}
