package com.example.web_calendar.controller;

import com.example.web_calendar.dto.EventDTO;
import com.example.web_calendar.model.Event;
import com.example.web_calendar.service.EventService;
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
    private final ModelMapper modelMapper;

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
    @GetMapping("/{eno}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long eno) {
        EventDTO eventDTO = eventService.readOne(eno);
        return ResponseEntity.ok(eventDTO);
    }

    // 이벤트 추가하기
    @PostMapping
    public void createEvent(@RequestBody Event event) {
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);
        eventService.create(eventDTO);
    }

    // 이벤트 수정하기
    @PutMapping("/{eno}")
    public void updateEvent(@PathVariable Long eno, @RequestBody Event event) {
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);
        eventService.modify(eno, eventDTO);
    }

    // 이벤트 삭제하기
    @DeleteMapping("/{eno}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eno) {
        eventService.remove(eno);
        return ResponseEntity.noContent().build(); // 삭제 성공 시 204 No Content 반환
    }

}
