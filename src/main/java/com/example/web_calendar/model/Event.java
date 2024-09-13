package com.example.web_calendar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Event extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;

    private LocalDateTime start;
    private LocalDateTime end;
    @Column(name = "is_all_day")
    private boolean isAllDay;

}
