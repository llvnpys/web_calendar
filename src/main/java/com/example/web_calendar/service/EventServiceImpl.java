package com.example.web_calendar.service;

import com.example.web_calendar.dto.EventDTO;
import com.example.web_calendar.model.Event;
import com.example.web_calendar.reporitory.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final ModelMapper modelMapper;
    private final EventRepository eventRepository;


    @Override
    public Long create(EventDTO eventDTO) {
        Event event = modelMapper.map(eventDTO, Event.class);
        eventRepository.save(event);
        return event.getEno();
    }

    @Override
    public EventDTO readOne(Long eno) {
        Optional<Event> result = eventRepository.findById(eno);

        Event event = result.orElseThrow();
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);

        return eventDTO;
    }


    @Override
    public void modify(Long eno, EventDTO eventDTO) {
        Optional<Event> result = eventRepository.findById(eno);

        Event event = result.orElseThrow();

        event.update(eventDTO);
    }

    @Override
    public void remove(Long eno) {
        eventRepository.deleteById(eno);
    }

    @Override
    public List<EventDTO> getEventsByRange(LocalDateTime start, LocalDateTime end) {
        List<Event> events = eventRepository.findByEndGreaterThanEqualOrStartLessThanEqual(start, end);

        return events.stream()
                .map(event -> modelMapper.map(event, EventDTO.class))
                .collect(Collectors.toList());
    }
}
