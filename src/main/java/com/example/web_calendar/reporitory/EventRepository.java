package com.example.web_calendar.reporitory;

import com.example.web_calendar.dto.EventDTO;
import com.example.web_calendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {
     List<Event> findByStartBetween(LocalDateTime start, LocalDateTime end);

}
