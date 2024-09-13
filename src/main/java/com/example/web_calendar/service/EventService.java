package com.example.web_calendar.service;

import com.example.web_calendar.dto.EventDTO;

import java.util.List;

public interface EventService {

    // CRUD
    Long create(EventDTO eventDTO);

    EventDTO readOne(Long eno);

    void modifyInfo(EventDTO eventDTO);
    void modifyDates(EventDTO eventDTO);

    void remove(Long eno);

    List<EventDTO> getEventByViewType(String viewType);

}
