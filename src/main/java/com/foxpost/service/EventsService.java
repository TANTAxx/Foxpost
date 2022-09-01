package com.foxpost.service;

import com.foxpost.entity.Events;
import com.foxpost.repository.EventsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EventsService {
    @Autowired
    private EventsRepository eventsRepository;

    public List<Events> findByAllEvents() {
        log.info(" <-- Find all Events");
        log.error(" <-- Can't find all Events");
        return eventsRepository.findAll();
    }

    public Events getEventById(short id) {
        log.info(" <-- Get Event By ID: {}", id);
        log.error(" <-- Can't Find Event By Id: {}",id);
        return eventsRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Events events) {
        log.info(" <-- Delete Event: {}", events);
        log.error(" <-- Can't Delete Event: {}",events);
        eventsRepository.save(events);
        log.info(" <-- Save Successful");
    }

    public void deleteEvent(short id) {
        log.info(" <-- Delete Event: {}", id);
        log.error(" <-- Can't Delete Event: {}",id);
        eventsRepository.deleteById(id);
        log.info(" <-- Delete Successful");
    }
}
