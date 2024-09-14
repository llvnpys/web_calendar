package com.example.web_calendar.controller;

import com.example.web_calendar.dto.EventDTO;
import com.example.web_calendar.model.Event;
import com.example.web_calendar.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


    @GetMapping
    public List<Event> getAllEvents() {
        // 모든 이벤트를 반환하는 로직
        return null;
    }

    // 특정 이벤트 가져오기
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO eventDTO = eventService.readOne(id);
        return ResponseEntity.ok(eventDTO);
    }

    // 이벤트 추가하기
    @PostMapping
    public void createEvent(@RequestBody Event event) {
        // 새로운 이벤트를 추가하는 로직
    }

    // 이벤트 수정하기
    @PutMapping("/{id}")
    public void updateEvent(@PathVariable Long id, @RequestBody Event event) {
        // 특정 이벤트를 수정하는 로직
    }

    // 이벤트 삭제하기
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        // 특정 이벤트를 삭제하는 로직
    }

}
