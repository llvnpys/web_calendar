package com.example.web_calendar.controller;

import com.example.web_calendar.dto.EventDTO;
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

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {

    private final EventService eventService;

    @GetMapping("/{viewType}") // viewType: day, week, month
    public String showCalendarByView(@PathVariable String viewType, Model model) {
        // viewType 검증 로직
        if (!Arrays.asList("daily", "weekly", "monthly").contains(viewType)) {
            throw new IllegalArgumentException("Invalid view type");
        }

        // 날짜 및 이벤트 로직 구현

        List<EventDTO> events = eventService.getEventByViewType(viewType);
        model.addAttribute("events", events);
        model.addAttribute("viewType", viewType);

        return "calendar";
    }
}
