package com.example.web_calendar.service;

import com.example.web_calendar.dto.EventDTO;
import com.example.web_calendar.model.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    // CRUD
    Long create(EventDTO eventDTO);

    EventDTO readOne(Long eno);

    void modify(Long eno, EventDTO eventDTO);

    void remove(Long eno);

    List<EventDTO> getEventsByRange(LocalDateTime start, LocalDateTime end);
}
