package com.example.web_calendar.controller;

import com.example.web_calendar.model.Event;
import com.example.web_calendar.service.EventService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {

    private final EventService eventService;

    @GetMapping("/calendar/{viewType}") // viewType: day, week, month
    public String showCalendarByView(@PathVariable String viewType, Model model) {
        // 날짜 및 이벤트 로직 구현

        // List<Event> events = eventService.getEventsByViewType(viewType);
        List<Event> events = null;
        model.addAttribute("events", events);
        model.addAttribute("viewType", viewType);
        return "calendar"; // calendar.html
    }
}
