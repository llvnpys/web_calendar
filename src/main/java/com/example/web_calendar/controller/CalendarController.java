package com.example.web_calendar.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
