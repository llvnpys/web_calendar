package com.example.web_calendar.service;

import com.example.web_calendar.dto.EventDTO;
import com.example.web_calendar.model.Event;
import com.example.web_calendar.reporitory.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

        // 예외처리
        Event event = result.orElseThrow();

        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);

        return eventDTO;
    }

    @Override
    public void modifyInfo(EventDTO eventDTO) {
        Optional<Event> result = eventRepository.findById(eventDTO.getEno());

        // 예외처리
        Event event = result.orElseThrow();

        event.updateInfo(eventDTO);
    }

    @Override
    public void modifyDates(EventDTO eventDTO) {
        Optional<Event> result = eventRepository.findById(eventDTO.getEno());
        // 예외처리
        Event event = result.orElseThrow();
        event.updateDates(eventDTO);
    }

    @Override
    public void remove(Long eno) {
        eventRepository.deleteById(eno);
    }

    @Override
    public List<EventDTO> getEventByViewType(String viewType) {
        List<Event> events;

        // 현재 날짜를 기준으로 이벤트를 필터링
        LocalDateTime now = LocalDateTime.now();

        switch (viewType) {
            case "daily":
                // 오늘의 이벤트 가져오기
                events = eventRepository.findByStartTimeBetween(
                        now.toLocalDate().atStartOfDay(),
                        now.toLocalDate().atTime(23, 59, 59)
                );
                break;
            case "weekly":
                // 이번 주의 이벤트 가져오기
                LocalDateTime startOfWeek = now.with(DayOfWeek.MONDAY).toLocalDate().atStartOfDay();
                LocalDateTime endOfWeek = now.with(DayOfWeek.SUNDAY).toLocalDate().atTime(23, 59, 59);
                events = eventRepository.findByStartTimeBetween(startOfWeek, endOfWeek);
                break;
            case "monthly":
                // 이번 달의 이벤트 가져오기
                LocalDateTime startOfMonth = now.withDayOfMonth(1).toLocalDate().atStartOfDay();
                LocalDateTime endOfMonth = now.withDayOfMonth(now.toLocalDate().lengthOfMonth()).toLocalDate().atTime(23, 59, 59);
                events = eventRepository.findByStartTimeBetween(startOfMonth, endOfMonth);
                break;
            default:
                events = new ArrayList<>();
        }

        // Event -> EventDTO 변환
        return events.stream()
                .map(event -> modelMapper.map(event, EventDTO.class))
                .collect(Collectors.toList());
    }


}
