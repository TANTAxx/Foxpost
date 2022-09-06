package com.foxpost.controller;

import com.foxpost.entity.Event;
import com.foxpost.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventsController {
    @Autowired
    private EventsService eventsService;

    @GetMapping("/events")
    private List<Event> getAllEvents() {
        return eventsService.findByAllEvents();
    }

    @GetMapping("/event/{id}")
    private Event getEvent(@PathVariable("id") short id) {
        return eventsService.getEventById(id);
    }


    @PostMapping("/event")
    private int saveEvent(@RequestBody Event event) {
        eventsService.saveOrUpdate(event);
        return event.getId();
    }

    @DeleteMapping("/event/{id}")
    private void deleteEvent(@PathVariable("id") short id) {
        eventsService.deleteEvent(id);
    }

}
