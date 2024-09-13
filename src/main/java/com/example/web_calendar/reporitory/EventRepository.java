package com.example.web_calendar.reporitory;

import com.example.web_calendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Long> {
}
