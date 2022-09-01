package com.foxpost.controller;

import com.foxpost.entity.Events;
import com.foxpost.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventsController {
    @Autowired
    private EventsService eventsService;

    @GetMapping("/events")
    private List<Events> getAllEvents() {
        return eventsService.findByAllEvents();
    }

    @GetMapping("/events/{id}")
    private Events getEvent(@PathVariable("id") short id) {
        return eventsService.getEventById(id);
    }


    @PostMapping("/events")
    private int saveEvent(@RequestBody Events events) {
        eventsService.saveOrUpdate(events);
        return events.getId();
    }

    @DeleteMapping("/event/{id}")
    private void deleteEvent(@PathVariable("id") short id) {
        eventsService.deleteEvent(id);
    }

}
