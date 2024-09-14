package com.example.web_calendar.controller;

import com.example.web_calendar.dto.EventDTO;
import com.example.web_calendar.model.Event;
import com.example.web_calendar.service.EventService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping()
public class CalendarController {

    @GetMapping("/calendar")
    public String getCalendar() {
        return "calendar";
    }

}
