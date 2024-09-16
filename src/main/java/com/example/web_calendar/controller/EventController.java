package com.example.web_calendar.controller;

import com.example.web_calendar.dto.EventDTO;
import com.example.web_calendar.model.Event;
import com.example.web_calendar.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    // Create
    @PostMapping
    public void createEvent(@RequestBody @Valid EventDTO eventDTO) {
        eventService.create(eventDTO);
    }

    // Read
    @GetMapping("/{eno}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long eno) {
        EventDTO eventDTO = eventService.readOne(eno);
        return ResponseEntity.ok(eventDTO);
    }

    // Update
    @PutMapping("/{eno}")
    public void updateEvent(@PathVariable Long eno,
                            @RequestBody @Valid EventDTO eventDTO) {
        eventService.modify(eno, eventDTO);
    }

    // Delete
    @DeleteMapping("/{eno}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eno) {
        eventService.remove(eno);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/range")
    public ResponseEntity<List<EventDTO>> getEventsByRange(
            @RequestParam String start,
            @RequestParam String end) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime startDateTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(end, formatter);

        List<EventDTO> events = eventService.getEventsByRange(startDateTime, endDateTime);
        return ResponseEntity.ok(events);
    }


    // 모든 이벤트를 반환하는 로직
    @GetMapping
    public List<Event> getAllEvents() {

        return null;
    }
}
