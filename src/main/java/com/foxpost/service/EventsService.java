package com.foxpost.service;

import com.foxpost.entity.Event;
import com.foxpost.repository.EventsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class EventsService {
    @Autowired
    private EventsRepository eventsRepository;

    public List<Event> findByAllEvents() {
        log.info(" <-- Find all Events");
        return eventsRepository.findAll();
    }

    public Event getEventById(short id) {
        log.info(" <-- Get Event By ID: {}", id);
        Event event = eventsRepository.findById(id).orElse(null);
        if (Objects.nonNull(id)) {
            return event;
        } else {
            log.error("Can't find Event");
            return null;
        }
    }

    public void saveOrUpdate(Event event) {
        log.info(" <-- Delete Event: {}", event);
        if (Objects.nonNull(event)) {
            eventsRepository.save(event);
        } else {
            log.error(" <-- Can't Save");
        }
        log.info(" <-- Save Successful");
    }

    public void deleteEvent(short id) {
        log.info(" <-- Delete Event: {}", id);
        if (Objects.nonNull(id)) {
            eventsRepository.deleteById(id);
        } else {
            log.error(" <-- Can't Delete");
        }
        log.info(" <-- Delete Successful");
    }
}
